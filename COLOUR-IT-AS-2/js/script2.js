//Function calls
readXML();


//Functions
function readXML(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        //Status 200 --> OK. Ready state 4 --> DONE.
        if (this.readyState == 4 && this.status == 200){
            showData(this,1); 
        }
    }
    xhttp.open("GET", "../xml/ProjectList.xml", true)  
    xhttp.send();
}


function showData(xml,projectNumber){
    //Selectors and variables 
    let xmlDoc = xml.responseXML; 
    let projectNames = xmlDoc.getElementsByTagName("projects")
    let x = projectNames[projectNumber].getElementsByTagName("requirements")
    
    let listLength = x.length;
    var table = "<table class='justify-content-center'><tr><th>Krav</th><th>Status</th><th>Deadline</th></tr>";
    for(var i = 0; i<listLength; i++)
    {
        table += "<tr><td>" + x[i].getElementsByTagName("requirementName")[0].childNodes[0].nodeValue + "</td>"
        + "<td>" + x[i].getElementsByTagName("requirementStatus")[0].childNodes[0].nodeValue + "</td>"
        + "<td>" + x[i].getElementsByTagName("requirementDeadline")[0].getElementsByTagName("day")[0].childNodes[0].nodeValue + "/"+
        x[i].getElementsByTagName("requirementDeadline")[0].getElementsByTagName("month")[0].childNodes[0].nodeValue + "/"+
        x[i].getElementsByTagName("requirementDeadline")[0].getElementsByTagName("year")[0].childNodes[0].nodeValue+"</td></tr>"
        
    }
    table += "</table>"
    
    document.getElementById("requirementTable").innerHTML = table;
    




}
