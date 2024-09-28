

### link code 

```angular2html
Parent parent = null;
try {
parent = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
} catch (IOException e) {
throw new RuntimeException(e);
}

Scene scene2 = new Scene(parent);

Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
window.setTitle("Sign Up");

window.setScene(scene2);
window.show();
```

### sql code

```angular2html
String sql = "select password from user where username = '" + username_str + "'";
final String URL = "jdbc:mysql://localhost:3306/thundertech";
final String USER = "root";
final String PASSWORD = "";


try {
Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(sql);
rs.next();

String pass = rs.getString(1);

}
```

### prepare statement
```angular2html
String sql = "select password from user where username = '" + username_str + "'";
final String URL = "jdbc:mysql://localhost:3306/thundertech";
final String USER = "root";
final String PASSWORD = "";


try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
PreparedStatement pst = con.prepareStatement(sql)) {

    // Set parameters
    pst.setString(1, usernameS);
    pst.setString(2, passwordS);
    pst.setString(3, emailS);
    pst.setString(4, phoneS);
    pst.setString(5, dobS.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    
    // Execute the SQL INSERT statement
    int row = pst.executeUpdate();

    if(row > 0){
    
    }
}

}

```



## invisible color

```angular2html
rgba(255, 255, 255, 0)
```