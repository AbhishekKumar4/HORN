function UserAction() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
         if (this.readyState == 4 && this.status == 200) {
             alert(this.responseText);
         }
    };
    xhttp.open("GET", "http://localhost:8080/upload-jar/getAllImages", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send()
}