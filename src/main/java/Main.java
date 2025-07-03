public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);


        try {
            new PersonBuilder().setName("Виталик").setSurname("Иванов").setAge(23).setAddress("Россия").build();
        }catch (IllegalStateException ex){
            System.out.println(ex.getMessage());
        }

        try {
            new PersonBuilder().setName("Никита").setSurname("Петров").setAge(-400).setAddress("Россия").build();
        }catch (IllegalStateException ex){
            System.out.println(ex.getMessage());
        }


        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
