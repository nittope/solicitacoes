$(document).ready(function(){
	$.ajax({
		url: "http://192.168.16.11/portalti/mensal.php",
		method: "GET",
		success: function(data) {
			console.log(data);
			var usuario = [];
			var chamados = [];

			for(var i in data) {
				usuario.push(data[i].first_name);
				chamados.push(data[i].qtde);
			}

			var options = {   			
			   
			    legend: {
			    	display: false,
			    }
			}

			var chartdata = {
				labels: usuario,
				datasets : [
					{
						
						backgroundColor: [
							"#33cc33",
							"#66ff33",
							"#99ff33",
							"#Ccff33",
							"#Ffff00",
							"#Ff9900",
							"#Cc3300"
						],
						hoverBorderColor: [
							"#33cc33",
							"#66ff33",
							"#99ff33",
							"#Ccff33",
							"#Ffff00",
							"#Ff9900",
							"#Cc3300"
						],
						data: chamados,
						
					}
				]
				
			};


		

			var ctx = $("#mycanvasmensal");

			var barGraph = new Chart(ctx, {
				type: 'bar',
				data: chartdata,
				options: options
				
			});
		},
		error: function(data) {
			console.log(data);
		}
	});
});
