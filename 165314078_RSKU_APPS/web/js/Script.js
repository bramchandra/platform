/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function logout() {
    var r = confirm("Anda Yakin Akan LogOut?")
    if (r == true) {
        document.cookie = "username=; expires=Thu, 01 Jan 1970 00:00:00 UTC;";
        alert("Anda Berhasil LogOut")
        window.open("index.html", "_self")
    }


}

function checkCookie() {
    var username = getCookie("username");
    if (username != "") {
        document.getElementById("logout").innerHTML = "<a onclick=\"logout()\">LogOut</a>"
        document.getElementById("login").innerHTML = "Logged in As : Admin"
    } else {
        document.getElementById("logout").innerHTML = "<a href=\"Login.html\" >Login</a>"
        document.getElementById("login").innerHTML = "User"
    }
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}
function checkCookieBeforeLoggedIn() {
    var username = getCookie("username");
    if (username == "") {
        alert("Mohon Maaf Untuk Mengakses Halaman Ini Anda Harus Login Terlebih Dahulu");
        window.open("Login.html", "_self")
    } else {
        document.getElementById("login").innerHTML = "Logged in As : Admin"
    }
}