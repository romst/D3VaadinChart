window.com_example_d3_pie_PieChart = function() {
	
	var data = this.getState().data;
	
	/*
	 * Bounds of component.
	 */
	var width = 960,
    height = 500,
    radius = Math.min(width, height) / 2;
	
	/*
	 * Create svg element.
	 */
	var svg = d3.select(this.getElement()).append("svg")
		.attr("id", "piechart")
		.attr("width", width)
		.attr("height", height)
		.append("g")
		.attr("transform", "translate(" + width / 2 + "," + height / 2 + ")");
	
	
	/*
	 * Color of pie-parts.
	 */
	var color = d3.scaleOrdinal()
    	.range(["#98abc5", "#8a89a6", "#7b6888", "#6b486b", "#a05d56", "#d0743c", "#ff8c00"]);

	/*
	 * Define pie arc.
	 */
	var arc = d3.arc()
    	.outerRadius(radius - 40)
    	.innerRadius(0);

	/*
	 * Define ring for labels. The radius of the label arc is 30 bigger, so it's outside of the pie.
	 */
	var labelArc = d3.arc()
    	.outerRadius(radius - 10)
    	.innerRadius(radius - 10);

	/*
	 * Generate pie.
	 */
	var pie = d3.pie()
    	.sort(null)
    	.value(function(d) { return d.y; });

	/*
	 * Apply pie data on svg.
	 * 
	 */
	var g = svg.selectAll(".arc")
    	.data(pie(data))
    	.enter().append("g")
    	.attr("class", "arc");

	/*
	 * Apply color to pie.
	 */
	g.append("path")
    	.attr("d", arc)
    	.style("fill", function(d) { return color(d.data.x); });

	/*
	 * Apply labels to svg.
	 */
	g.append("text")
    	.attr("transform", function(d) { return "translate(" + labelArc.centroid(d) + ")"; })
    	.attr("dy", 5)
    	.style("text-anchor", "middle")
    	.text(function(d) { return d.data.x; });


	function type(d) {
		d.y = +d.y;
		return d;
	}
}