import java.util.*;

public class Main {
    public static void main(String[] args) {
        RPGCharacter shooter = new ShooterCharacter("John", 100, 5, 80, 70);
        RPGCharacter mage = new MageCharacter("Alice", 80, 6, 100, 90, 75);

        RPGAccessory gun = new GunAccessory("Shotgun", "Shotgun", "High", 8);
        RPGAccessory magicKey = new MagicKeyAccessory("Teleportation Key", "Teleportation", 5);

        shooter.viewStats();
        mage.viewStats();

        gun.use();
        magicKey.use();

        CustomSet<String> set = new CustomSet<>();

        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");

        System.out.println("Set contains 'Apple': " + set.contains("Apple"));
        System.out.println("Set size: " + set.size());

        set.remove("Banana");
        System.out.println("After removing 'Banana', set contains 'Banana': " + set.contains("Banana"));
    }

    public interface RPGCharacter {
        void viewStats();
    }

    public static class ShooterCharacter implements RPGCharacter {
        private final String name;
        private final int hp;
        private final int level;
        private final int accuracy;
        private final int evasion;

        public ShooterCharacter(String name, int hp, int level, int accuracy, int evasion) {
            this.name = name;
            this.hp = hp;
            this.level = level;
            this.accuracy = accuracy;
            this.evasion = evasion;
        }

        @Override
        public void viewStats() {
            System.out.println("Name: " + name);
            System.out.println("Job: Shooter");
            System.out.println("HP: " + hp);
            System.out.println("Accuracy: " + accuracy);
            System.out.println("Evasion: " + evasion);
            System.out.println("Level: " + level);
        }
    }

    public static class MageCharacter implements RPGCharacter {
        private final String name;
        private final int hp;
        private final int level;
        private final int mp;
        private final int intelligence;
        private final int resistance;

        public MageCharacter(String name, int hp, int level, int mp, int intelligence, int resistance) {
            this.name = name;
            this.hp = hp;
            this.level = level;
            this.mp = mp;
            this.intelligence = intelligence;
            this.resistance = resistance;
        }

        @Override
        public void viewStats() {
            System.out.println("Name: " + name);
            System.out.println("Job: Mage");
            System.out.println("HP: " + hp);
            System.out.println("MP: " + mp);
            System.out.println("Intelligence: " + intelligence);
            System.out.println("Resistance: " + resistance);
            System.out.println("Level: " + level);
        }
    }

    public interface RPGAccessory {
        void use();
    }

    public static class GunAccessory implements RPGAccessory {
        private final String name;
        private final String gunType;
        private final String damage;
        private final int ammoCapacity;

        public GunAccessory(String name, String gunType, String damage, int ammoCapacity) {
            this.name = name;
            this.gunType = gunType;
            this.damage = damage;
            this.ammoCapacity = ammoCapacity;
        }

        @Override
        public void use() {
            System.out.println("Equipped " + name + " - " + gunType);
        }
    }

    public static class MagicKeyAccessory implements RPGAccessory {
        private final String name;
        private final String enchantment;
        private final int usage;

        public MagicKeyAccessory(String name, String enchantment, int usage) {
            this.name = name;
            this.enchantment = enchantment;
            this.usage = usage;
        }

        @Override
        public void use() {
            System.out.println("Equipped " + name + " - " + enchantment);
        }
    }

    public static class CustomSet<E> implements Set<E> {
        private final Map<E, Object> map;
        private static final Object DUMMY_VALUE = new Object();

        public CustomSet() {
            this.map = new HashMap<>();
        }

        @Override
        public boolean add(E e) {
            return map.put(e, DUMMY_VALUE) == null;
        }

        @Override
        public boolean remove(Object o) {
            return map.remove(o) == DUMMY_VALUE;
        }

        @Override
        public boolean contains(Object o) {
            return map.containsKey(o);
        }

        @Override
        public int size() {
            return map.size();
        }

        @Override
        public Iterator<E> iterator() {
            return map.keySet().iterator();
        }

        @Override
        public void clear() {
            map.clear();
        }

        @Override
        public boolean isEmpty() {
            return map.isEmpty();
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return map.keySet().containsAll(c);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Object[] toArray() {
            return map.keySet().toArray();
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return map.keySet().toArray(a);
        }
    }
}