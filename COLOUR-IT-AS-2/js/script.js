//Dynamic display only works if running on a server e.g. Live preview on Brackets or with Live Server extension on VSCode.
//Function calls
readXML();


//Functions
function readXML(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        //Status 200 --> OK. Ready state 4 --> DONE.
        if (this.readyState == 4 && this.status == 200){
            showData(this,0); 
        }
    }
    xhttp.open("GET", "../xml/ProjectList.xml", true)  
    xhttp.send();
}


function showData(xml,projectNumber){
    //Selectors and variables 
    let xmlDoc = xml.responseXML; 
    let projectNames = xmlDoc.getElementsByTagName("projects") //Selector for projects
    //Selector for requirements for a given projectNumber. 
    let x = projectNames[projectNumber].getElementsByTagName("requirements") 
    //Number of requirements in a given project.
    let listLength = x.length;
    //Defines the table with classes that is to be added to the website. 
    var table = "<table class='justify-content-center'><tr><th>Krav</th><th>Status</th><th>Deadline</th></tr>";
    for(var i = 0; i<listLength; i++) 
    {
        /*
        Loops through every requirements and gets the requirement name, requirement status and requirement deadline
        and adds it as table data to the table. 
        */ 
        table += "<tr><td>" + x[i].getElementsByTagName("requirementName")[0].childNodes[0].nodeValue + "</td>"
        + "<td>" + x[i].getElementsByTagName("requirementStatus")[0].childNodes[0].nodeValue + "</td>"
        + "<td>" + x[i].getElementsByTagName("requirementDeadline")[0].getElementsByTagName("day")[0].childNodes[0].nodeValue + "/"+
        x[i].getElementsByTagName("requirementDeadline")[0].getElementsByTagName("month")[0].childNodes[0].nodeValue + "/"+
        x[i].getElementsByTagName("requirementDeadline")[0].getElementsByTagName("year")[0].childNodes[0].nodeValue+"</td></tr>"
        
    }
    table += "</table>" //Adding end tag to the table.
    
    //Sets the div with id 'requirementTable' HTML content to the dynamiclly created table. 
    document.getElementById("requirementTable").innerHTML = table;
    




}
