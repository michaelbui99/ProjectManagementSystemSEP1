

function displayProjectData(){
    let parser = new DOMParser();
    let xmlDOC = parser.parseFromString(text, "text/xml") //TODO: Change text to filename. 
    
}

function readXML(){
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function(){
        //Status 200 --> OK. Ready state 4 --> DONE.
        if (this.readyState == 4 && this.status == 200){
            showData(this); //TODO: change this to dispalyProjectData() when the function is done. 
        }
    }
    xhttp.open("GET", "../../ProjectList.xml", true)  
    xhttp.send();
}


function showData(xml){
    //Selecttors and variables
    var i; 
    let xmlDoc = xml.responseXML; 
    let projectNames = xmlDoc.getElementsByTagName("projectName")
    let requirementNames = xmlDoc.querySelectorAll("requirements" > "name");
    let requirementStatus = xmlDoc.querySelectorAll("requrements" > "status")
    let listLength = requirementNames.listLength;

    var table = "<table><tr><th>Krav</th><th>Status</th></tr>";

    for (var i = 0; i<listLength; i++){
        table +=
        "<tr><td>" + requirementNames[i].childNodes[0].nodeValue + "</td>" +
        "<td>" + requirementStatus[i].childNodes[0].nodeValue + "</td></tr>";
        
    }
    




}
