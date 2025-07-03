public class PersonBuilder {
    private String name;
    private String surname;
    private Integer age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст отрицательный");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    // Создайте класс PersonBuilder, наполните его полями для данных будущего объекта класса Person и методами их наполняющими.
    // (не забудьте про "IllegalArgumentException" в случае ввода недопустимых данных)

    public Person build() {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Поле name = null");
        }
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Поле surname = null");
        }
        if (age != null) {
            return new Person(name, surname, age);
        } else {
            return new Person(name, surname);
        }
    }
}
