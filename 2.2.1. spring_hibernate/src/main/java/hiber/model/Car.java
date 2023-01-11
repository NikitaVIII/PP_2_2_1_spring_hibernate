package hiber.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "car")
//    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    public Car() {}

    public Car(String model, int series, User user) {
        this.model = model;
        this.series = series;
        this.user = user;
        //user.setCar(this);
    }

    public String getmodel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public long getId() {
        return id;
    }

    public void setmodel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", user=" + user.getFirstName() +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
