function UserAction() {
    var jsonResponse;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
         if (this.readyState == 4 && this.status == 200) {
             jsonResponse =  JSON.parse(this.responseText);
             alert(this.responseText);
             var table = document.createElement('table');
             var listofurls = jsonResponse.urls;
             for (var i = 1; i < listofurls.length ; i++){
             var tr = document.createElement('tr');   
             console.log(listofurls[i]);
             var td1 = document.createElement('td');
         
             var img = document.createElement('img');
             img.src = listofurls[i];
         
             td1.appendChild(img);
             tr.appendChild(td1); 
             table.appendChild(tr);
             document.body.appendChild(table);
         }
    };
}
    xhttp.open("GET", "http://localhost:8080/upload-jar/getAllImages", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send()


}

