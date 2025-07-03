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

            // Если же мы передали неподходящие данные билдеру (например, некорректный возрст builder.setAge(-100)),
            // то именно этот метод должен выкинуть IllegalArgumentException с осмысленным сообщением.

            throw new IllegalArgumentException("Возраст отрицательный");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }


    public Person build() {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Поле name = null");
        }
        if (surname == null || surname.isEmpty()) {

            // В случае, если мы билдеру не указали достаточное количество данных (например, не указали фамилию),
            // то метод build() должен выкинуть IllegalStateException с осмысленным сообщением.

            throw new IllegalStateException("Поле surname = null");
        }
        if (age != null) {
            return new Person(name, surname, age);
        } else {
            return new Person(name, surname);
        }
    }
}
