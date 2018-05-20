package SendEmail;

public class Account {
  
  private int _id;
  private String _name;
  private int _age;
  
  public void setId(int id){
    _id = id;
  }
  
  public int getId(){
    return _id;
  }
  
  public void setName(String name){
    _name = name;
  }
  
  public String getName(){
    return _name;
  }
  
  public void setAge(int age){
    _age = age;
  }
  
  public int getAge(){
    return _age;
  }
  
}