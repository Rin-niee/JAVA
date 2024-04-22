public class Автор implements Serializable {

    private String фамилия;
    private String инициалы;

    public Автор(String фамилия, String инициалы) {
        this.фамилия = фамилия;
        this.инициалы = инициалы;
    }

    public String getФамилия() {
        return фамилия;
    }

    public void setФамилия(String фамилия) {
        this.фамилия = фамилия;
    }

    public String getИнициалы() {
        return инициалы;
    }

    public void setИнициалы(String инициалы) {
        this.инициалы = инициалы;
    }

    @Override
    public String toString() {
        return фамилия + " " + инициалы;
    }
}

Pattern pattern = Pattern.compile("^(\\d+)\\. (.*), (.*)\\. (.*)\\. (\\d{4});(\\d\\(\\d\\)):(\\d+)-(\\d+)$");
Matcher matcher = pattern.matcher(text);
while (matcher.find()) {
    String авторы = matcher.group(2);
    String[] авторыSplit = авторы.split(",");
    for (String автор : авторыSplit) {
        String[] авторSplit = автор.trim().split(" ");
        Автор автор = new Автор(авторSplit[0], авторSplit[1]);
        // Сохранить автора в список
    }
}
FileOutputStream fileOutputStream = new FileOutputStream("авторы.ser");
ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
objectOutputStream.writeObject(авторы);
objectOutputStream.close();
FileInputStream fileInputStream = new FileInputStream("авторы.ser");
ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
List<Автор> авторы = (List<Автор>) objectInputStream.readObject();
objectInputStream.close();

for (Автор автор : авторы) {
    if (!автор.фамилия.matches("^[А-ЯЁа-яё]+$")) {
        System.out.println(автор);
    }
}

