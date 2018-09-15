<html>
<head>
    <LINK rel="stylesheet" type="text/css"href="demo.css" />

<script type="text/javascript">

var isIE;
var completeTable;
var completeField;
var autorow;
var req;


function getElementY(element){
	var targetTop = 0;
	if (element.offsetParent) {
		while (element.offsetParent) {
			targetTop += element.offsetTop;
            element = element.offsetParent;
		}
	} else if (element.y) {
		targetTop += element.y;
    }
	return targetTop;
}

function init() {
    completeField = document.getElementById("complete-field");
    var menu = document.getElementById("auto-row");
    autorow = document.getElementById("menu-popup");
    autorow.style.top = getElementY(menu) + "px";
    completeTable = document.getElementById("completeTable");
    completeTable.setAttribute("bordercolor", "white");
}

function initRequest(url) {
    if (window.XMLHttpRequest) {
        return new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        isIE = true;
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
}


function doCompletion() {
    if (completeField.value == "") {
        clearTable();
    } else {
        var url = "completarFuncionarios?action=complete&id=" + escape(completeField.value);
        var req = initRequest(url);
        req.onreadystatechange = function() {
            if (req.readyState == 4) {
                if (req.status == 200) {
                    parseMessages(req.responseXML);
                } else if (req.status == 204){
                    clearTable();
                }
            }
        };
        req.open("GET", url, true);
        req.send(null);
    }
}

function parseMessages(responseXML) {
    clearTable();
	var employees = responseXML.getElementsByTagName("employees")[0];
    if (employees.childNodes.length > 0) {
        completeTable.setAttribute("bordercolor", "black");
        completeTable.setAttribute("border", "1");
    } else {
        clearTable();
    }
    
    for (loop = 0; loop < employees.childNodes.length; loop++) {
	    var employee = employees.childNodes[loop];
        var firstName = employee.getElementsByTagName("firstName")[0];
        var lastName = employee.getElementsByTagName("lastName")[0];
        var employeeId = employee.getElementsByTagName("id")[0];
        appendEmployee(firstName.childNodes[0].nodeValue,lastName.childNodes[0].nodeValue, employeeId.childNodes[0].nodeValue);
    }
}

function clearTable() {
    if (completeTable) {
      completeTable.setAttribute("bordercolor", "white");
      completeTable.setAttribute("border", "0");
      completeTable.style.visible = false;
      for (loop = completeTable.childNodes.length -1; loop >= 0 ; loop--) {
        completeTable.removeChild(completeTable.childNodes[loop]);
      }
    }
}

function appendEmployee(firstName,lastName,employeeId) {
    var firstNameCell;
    var lastNameCell;
    var row;
    var nameCell;
    if (isIE) {
        row = completeTable.insertRow(completeTable.rows.length);
        nameCell = row.insertCell(0);
    } else {
        row = document.createElement("tr");
        nameCell = document.createElement("td");
        row.appendChild(nameCell);
        completeTable.appendChild(row);
    }
    row.className = "popupRow";
    nameCell.setAttribute("bgcolor", "#FFFAFA");

    
    var linkElement = document.createElement("a");
    linkElement.className = "popupItem";
    linkElement.setAttribute("href", "completarFuncionarios?action=lookup&id=" + employeeId);
    linkElement.appendChild(document.createTextNode(firstName + " " + lastName));
    nameCell.appendChild(linkElement);
}
</script>
 <title>Globalcode</title>
</head>

 <body onload="init()"> 
 <h3>Globalcode - AJAX </h3> 
 Nomes da nossa lista &quot;Joao&quot;, &quot;Jose&quot;, &quot;Marcia&quot;, &quot;Pace&quot;, &quot;Pereira&quot;.
 <hr/>
  <form name="formIndice" action="completarFuncionarios" method="get">
   <input type="hidden" name="action" value="lookupbyname"/>
   <table border="0" cellpadding="5" cellspacing="0">
    <tr>
     <td><b>Nome do funcionário:</b></td>
     <td>
      <input type="text" size="20" autocomplete="off" id="complete-field" name="id"
             onkeyup="doCompletion();">
     </td>
     <td align="left">
      <input id="submit_btn" type="Submit" value="Buscar Funcionário">
     </td>
    </tr>
    <tr><td id="auto-row" colspan="2">&nbsp;<td/></tr>
   </table>
  </form>
 <!-- Aqui sera inserido a janela de auto-complete -->  
 <div style="position: absolute; top:170px;left:140px" id="menu-popup">
 <table id="completeTable" border="1" bordercolor="black" cellpadding="0" cellspacing="0" />
 </div>

 </body>
</html>
