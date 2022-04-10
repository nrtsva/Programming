package DragonParameters;

import java.time.LocalDateTime;

public class Dragon {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer age; //Значение поля должно быть больше 0, Поле может быть null
    private Color color; //Поле не может быть null
    private DragonType type; //Поле не может быть null
    private DragonCharacter character; //Поле не может быть null
    private DragonHead head;

    private static int uniqueId = 0;

    public Dragon() {
        id = uniqueId++;
        name = null;
        coordinates = new Coordinates();
        creationDate = LocalDateTime.now();
        age = null;
        color = null;
        type = null;
        character = null;
        head = new DragonHead();
    }

    public Dragon( int id, String name, Coordinates coordinates, java.time.LocalDateTime creationDate, Integer age,
                   Color color, DragonType type, DragonCharacter character, DragonHead head) {
        this.id = id + uniqueId++;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.age = age;
        this.color = color;
        this.type = type;
        this.character = character;
        this.head = head;
    }

    public void setName( String name ) {
        this.name = name;
    }
    public void setCoordinates( Coordinates coord ) {
        this.coordinates = coord;
    }
    public void setAge( Integer age ) {
        this.age = age;
    }
    public void setColor( Color color ) {
        this.color = color;
    }
    public void setType( DragonType type ) {
        this.type = type;
    }
    public void setCharacter( DragonCharacter character ) {
        this.character = character;
    }
    public void setHead( DragonHead head ) {
        this.head = head;
    }

    public int getID() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    public java.time.LocalDateTime getCreationDate() {
        return creationDate;
    }
    public Integer getAge() {
        return age;
    }
    public Color getColor() {
        return color;
    }
    public DragonType getType() {
        return type;
    }
    public DragonCharacter getCharacter() {
        return character;
    }
    public DragonHead getHead() {
        return head;
    }

    @Override
    public String toString() {
        return "Dragon{id = " + id +"; name = " + name + "; coordinates {x; y} = " + coordinates.toString() + "; creationTime = " + creationDate.toString() +"; age = " +
                age + "; color = " + color + "; type = " + type + "; character = " + character +
                "; head {size, eyesCount, toothCount} = " + head.toString() + "}";

    }
}
