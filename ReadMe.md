

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


## invisible color

```angular2html
rgba(255, 255, 255, 0)
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





## set Parameter
```angular2html
 String sql = "insert into post(username,domain,title,details,expt_date,expt_cost) values (?,?,?,?,?,?)";
            final String URL = "jdbc:mysql://localhost:3306/thundertech";
            final String USER = "root";
            final String PASSWORD = "";


            try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pst = con.prepareStatement(sql)) {
                System.out.println(6);

                // Set parameters
                pst.setString(1, LoginController.user);
                pst.setString(2, DashboardController.domain + "");
                pst.setString(3, title_str);
                pst.setString(4, description_str);
                pst.setString(5, expt_date_rcv.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                pst.setString(6, expt_costS);

                // Execute the SQL INSERT statement
                int row = pst.executeUpdate();

                if(row > 0){
```


### fetch data
```angular2html
String heading = resultSet.getString("title");

                String about = domName +" - " +resultSet.getString("expt_cost")+ "$";
                String context = resultSet.getString("details");
                int post_number = Integer.parseInt(resultSet.getString("post_no"));
```