$(document).ready(function() {
  $.ajax({
      url: "http://localhost:8080/api/getSongs",
      type: "GET",
      success: function(data) {
          var table = $("<table>").addClass("table").append($("<thead>").append($("<tr>")
            .append($("<th>").text("ID"))
            .append($("<th>").text("First Name"))
            .append($("<th>").text("Last Name"))
            .append($("<th>").text("Email"))
          )).append($("<tbody>"));
        
          
          for (var i = 0; i < data.length; i++) {
            var row = $("<tr>")
              .append($("<td>").text(data[i].id))
              .append($("<td>").text(data[i].firstName))
              .append($("<td>").text(data[i].lastName))
              .append($("<td>").text(data[i].email));
            table.append(row);
          }
        
          $("#table-container").append(table);
          
          // Add CSS styling to the table
          table.css({
            "border-collapse": "collapse",
            "width": "100%",
            "margin": "0 auto",
            "font-family": "Arial, sans-serif",
            "border": "2px solid black",
            "font-size": "14px",
            "background-color": "#f2f2f2",
            "color": "black"
          });
          table.find('th').css({
            "background-color": "rgb(8 110 120 / 69%)",
            "color": "white",
            "text-align": "center",
            "padding": "10px"
          });
          table.find('td').css({
            "text-align": "center",
            "padding": "8px"
          });
          table.find('tr:nth-child(even)').css({
            "background-color": "#ddd"
          });
        
          $(table).DataTable({
            dom: 'Bfrtip',
            buttons: [
              'excelHtml5'
            ]
          });
        }
  });
});



