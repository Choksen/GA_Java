package com.maks.collections;


import com.maks.collections.Animal.Cat;
import com.maks.collections.Animal.Dog;
import com.maks.collections.Animal.Parrot;
import com.maks.collections.Animal.Pet;

import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        System.out.println("1 задание");
        task1();
        System.out.println("2 задание");
        task2();
        System.out.println("3 задание");
        task3();
        System.out.println("4 задание");
        task4();
        System.out.println("5 задание");
        task5();
        System.out.println("6 задание");
        task6();
        System.out.println("7 задание");
        task7();
        System.out.println("8 задание");
        task8();
        System.out.println("9 задание");
        task9();
        System.out.println("10 задание");
        task10();
    }

    public static List<Box> createBox() {
        ArrayList<Box> box = new ArrayList<>();
        box.add(new Box(100, 2, 3, 4));
        box.add(new Box(500, 6, 7, 8));
        box.add(new Box(201, 15, 14, 9));
        box.add(new Box(199, 16, 13, 10));
        box.add(new Box(400, 17, 12, 11));
        return box;
    }

    public static void task1() {
        //Создать динамический массив, содержащий объекты класса Box
       List<Box> boxArray = createBox();

        //Распечатать его содержимое используя for each.
        for (Object print : boxArray) {
            System.out.println(print.toString());
        }
        System.out.println();

        //Изменить вес первого ящика на 1.
        boxArray.get(0).weight = 1;
        System.out.println(boxArray.get(0).toString());
        System.out.println();

        //Удалить последний ящик.
        boxArray.remove(boxArray.size() - 1);
        for (Object print : boxArray) {
            System.out.println(print.toString());
        }
        System.out.println();

        //Удалить все ящики.
        boxArray.clear();
    }

    public static void task2() {
        //1 способ, Перебор
        List<Box> boxList = createBox();;
        Box[] boxArray1 = new Box[boxList.size()];
        for (int i = 0; i < boxList.size(); i++) {
            boxArray1[i] = boxList.get(i);
        }
        for (Object box : boxArray1) {
            System.out.println(box);
        }
        System.out.println();

        //2 способ, toArray
        Box[] boxArray2 = new Box[boxList.size()];
        boxList.toArray(boxArray2);
        for (Object box : boxArray1) {
            System.out.println(box);
        }
        System.out.println();

        //3 способ, Stream API
        Box[] boxArray3 = boxList.stream().toArray(Box[]::new);
        for (Object box : boxArray1) {
            System.out.println(box);
        }
        System.out.println();
    }

    public static void task3() {
        Set<Box> boxTreeSet = new TreeSet<>();
        boxTreeSet.add(new Box(100, 2, 3, 200));
        boxTreeSet.add(new Box(5, 6, 7, 200));
        boxTreeSet.add(new Box(18, 15, 14, 5));
        boxTreeSet.add(new Box(19, 16, 13, 11));
        boxTreeSet.add(new Box(20, 17, 12, 18));
        for (Object box : boxTreeSet) {
            System.out.println(box);
        }
        System.out.println();
    }

    public static void task4() {
        Set<Integer> firstSet = new HashSet<>();
        Set<Integer> secondSet = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int i = 1; i < 11; i++) {
            firstSet.add(i);
        }
        for (int i = 6; i < 16; i++) {
            secondSet.add(i);
        }
        System.out.println(firstSet);
        System.out.println(secondSet);
        union(firstSet, secondSet, result);
        intersect(firstSet, secondSet, result);
        System.out.println();
    }

    public static void union(final Set<?>... set) {
        set[2].clear();
        set[2].addAll((HashSet) set[0]);
        set[2].addAll((HashSet) set[1]);
        System.out.println(set[2]);
    }

    public static void intersect(Set<?>... set) {
        set[2].clear();
        set[2].addAll((HashSet) set[0]);
        set[2].retainAll(set[1]);
        System.out.println(set[2]);
    }

    public static void task5() {
        Queue<Box> boxArrayDeque = new ArrayDeque<>();
        boxArrayDeque.offer(new Box(1, 2, 3, 4));
        boxArrayDeque.offer(new Box(5, 6, 7, 8));
        boxArrayDeque.offer(new Box(9, 10, 11, 12));
        for (Box box : boxArrayDeque) {
            System.out.println(box);
        }
        System.out.println();
        boxArrayDeque.poll();
        boxArrayDeque.poll();
        for (Box box : boxArrayDeque) {
            System.out.println(box);
        }
        System.out.println();
    }

    public static void task6() {
        List<Box> boxArray = createBox();
        List<Box> filterWeightBox = boxArray.stream()
                .filter(box -> box.weight > 200)
                .collect(Collectors.toList());
        for (Box box : filterWeightBox) {
            System.out.println(box);
        }
        System.out.println();
    }

    public static void task7() {
        Map<String, Toy> toyMap = new HashMap<>();
        toyMap.put("car", new Toy(12, "with big wheels", true));
        toyMap.put("bear", new Toy(342, "plush", false));
        toyMap.put("doll", new Toy(10, "male", false));
        toyMap.put("weapon", new Toy(777, "with live ammunition", true));
        toyMap.put("hammer", new Toy(12, "without nails", false));

        //не очень понял смысл в отдельных методах для перебора, но сделал
        printToys(toyMap);
        printToysNames(toyMap);
        printToysDetails(toyMap);

    }

    public static void printToys(final Map<String, Toy> toyMap) {
        for (Object toy : toyMap.entrySet()) {
            System.out.println(toy);
        }
        System.out.println();
    }

    public static void printToysNames(final Map<String, Toy> toyMap) {
        for (Object toy : toyMap.keySet()) {
            System.out.println(toy);
        }
        System.out.println();
    }

    public static void printToysDetails(final Map<String, Toy> toyMap) {
        for (Object toy : toyMap.values()) {
            System.out.println(toy);
        }
        System.out.println();
    }

    public static void task8() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Maksim", 192, 3, 10, 9, 10));
        students.add(new Student("Vladimir", 192, 2, 10, 10, 7));
        students.add(new Student("Vladislav", 194, 3, 1, 1, 1));
        students.add(new Student("Yuri", 191, 1, 2, 3, 1));
        students.add(new Student("Evgeniy", 192, 2, 3, 4, 3));

        for (Object student : students) {
            System.out.println(student);
        }
        System.out.println();

        deleteIgnoramus(students);
        printStudents(students, 3);

    }

    public static void deleteIgnoramus(final List<Student> students) {

        List<Student> Ignoramus = students.stream()
                .filter(student -> student.averageValue(student.math, student.biology, student.physics) < 3)
                .collect(Collectors.toList());
        students.removeAll(Ignoramus);
        for (Student student : students) {
            student.course++;
            System.out.println(student);
        }
        System.out.println();
    }

    public static void printStudents(final List<Student> students, final int course) {
        students.stream()
                .filter(student -> student.course == course)
                .forEach(System.out::println);
        System.out.println();
    }

    public static void task9() {
        Map<String, Pet> pets = new HashMap<>();
        pets.put("Barsik", new Cat("orange", 5, true));
        pets.put("Bobik", new Dog("black", 1, true));
        pets.put("Murza", new Cat("white", 12, true));
        pets.put("Kakadu", new Parrot("red", 2, false));
        pets.put("Max", new Dog("grey", 12, true));
        printPet(pets);
        System.out.println();
    }

    public static void printPet(final Map<String, Pet> pets) {
        for (String pet : pets.keySet()) {
            System.out.println(pet);
        }
    }

    public static void task10() {
        List<Integer> personsArrayList = new ArrayList<Integer>();
        removeEverySecondPerson(personsArrayList);
        List<Integer> personsLinkedList = new LinkedList<>();
        removeEverySecondPerson(personsLinkedList);


    }

    public static void removeEverySecondPerson(final List<Integer> persons) {
        double startTime = System.nanoTime();
        for (int i = 0; i < 20; i++) {
            persons.add((int) (Math.random() * 100));
        }
        while (persons.size() > 1) {
            for (int i = 1; i < persons.size(); i++) {
                persons.remove(i);
            }
            System.out.println(persons);
        }
        double finishTime = System.nanoTime();
        System.out.println(finishTime - startTime);
        System.out.println();
    }
}