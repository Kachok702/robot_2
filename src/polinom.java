public class polinom {
    public static void main(String[] args) {
        // your code
        String text = "Madam, I'm Adam!"; // вводим текст
        text = text.toLowerCase().replaceAll("[^A-Za-z1-9]+", ""); // в введенном тексте уменьшаем все буквы и убираем лишние символы
        System.out.println(text); // выводим что получилось
        int lenghtText = text.length(); // длина в символах полученного текста
        StringBuilder text0 = new StringBuilder(text).reverse(); // вводим новую переменуюю СтрингБилдер и поменял местами сивмолы
        System.out.println(text0); // выводим полуенное слово
        // проверяем все ли сивмолы одинаковые
        int i = 0;
        int j = 0;
        while (i != lenghtText) {
            if (text.charAt(i) == text0.charAt(i)){
                j++;
            }
            i++;
        }
        System.out.println("Одинаковых букв: " + j);
                System.out.println(text.contentEquals(text0));
    }

}
