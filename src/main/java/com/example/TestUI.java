package com.example;

import java.util.Arrays;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Simple UI/Servlet.
 */
@Theme("valo")
@Widgetset("com.example.d3.Widgetset")
public class TestUI extends UI {

	private static final long serialVersionUID = 5531919908081245741L;
	private AbstractJavaScriptComponent component;

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout();

		final ComboBox chartTypes = new ComboBox("Chart Types:", Arrays.asList(ChartType.values()));
		chartTypes.setNullSelectionAllowed(false);
		final Button button = new Button("Generate data");
		button.setEnabled(false);

		chartTypes.addValueChangeListener(new ValueChangeListener() {
			private static final long serialVersionUID = 2179963942315674721L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				button.setEnabled(chartTypes.getValue() != null);
			}
		});

		button.addClickListener(e -> {
			ChartType type = (ChartType) chartTypes.getValue();

			if (component != null)
				layout.removeComponent(component);

			component = ChartFactory.getChart(type);
			
			if (component != null)
				layout.addComponent(component);
			else
				Notification.show("Error", "Could not create object of Type: " + type.toString()
						+ ". Check, if type is managed in ChartFactory.", Type.ERROR_MESSAGE);
		});

		layout.addComponent(chartTypes);
		layout.addComponents(button);
		layout.setMargin(true);
		layout.setSpacing(true);

		setContent(layout);
	}

	@WebServlet(urlPatterns = "/*", name = "TestServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = TestUI.class, productionMode = false)
	public static class TestServlet extends VaadinServlet {

		private static final long serialVersionUID = 2454433783353486285L;
	}
}
