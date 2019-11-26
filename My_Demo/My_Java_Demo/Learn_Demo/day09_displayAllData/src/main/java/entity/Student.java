package entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version :
 * @-----cdoing：utf-8-----
 * @Author :
 * @Project :
 * @Time :
 * @修改原因 :
 * @more info   ：
 * @more info   ：
 * @more info   ：
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String address;
    private String qqAccount;
    private String email;
//
//    public Student() {
//    }
//
//    public Student(Integer id, String name, String gender, Integer age, String address, String qqAccount, String email) {
//        this.id = id;
//        this.name = name;
//        this.gender = gender;
//        this.age = age;
//        this.address = address;
//        this.qqAccount = qqAccount;
//        this.email = email;
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", gender='" + gender + '\'' +
//                ", age=" + age +
//                ", address='" + address + '\'' +
//                ", qqAccount='" + qqAccount + '\'' +
//                ", email='" + email + '\'' +
//                '}';
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getQqAccount() {
//        return qqAccount;
//    }
//
//    public void setQqAccount(String qqAccount) {
//        this.qqAccount = qqAccount;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
}
