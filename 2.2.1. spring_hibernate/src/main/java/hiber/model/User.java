package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id //по дефолу поле с данной анотацией является primary key (уникальное и != null)
   @GeneratedValue(strategy = GenerationType.IDENTITY) //стратегия генерации значений поля id
   private Long id;

   @Column(name = "firstname")
   private String firstName;

   @Column(name = "lastname")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne (cascade = CascadeType.ALL)
   @JoinColumn (name = "id_car") //автоматически создается столбец id_car который является внещним ключем для связи с таблицей cars
   private Car car;

   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public void setCar(Car car) {
      this.car = car;
   }

   public Car getCar() {
      return car;
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\'' +
              ", car=" + car +
              '}';
   }
}
