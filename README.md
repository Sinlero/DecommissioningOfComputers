# Гайд

---

### Шаг 1
Создать шаблон документа, в предполагаемые места замены вставить ключевые значения

---

### Шаг 2

Создать мапу с ключами(которые в шаблоне документа) и их значениями

Например:
```java
        Map<String,String> params = new HashMap<>();
        params.put("idFirstName", "С.В. Барышников");
        params.put("idSecondName", "А.Ю. Милинский");
        params.put("idThirdName", "А.С. Матевосян");
        params.put("idState", "Плачевное");
        params.put("idOsName", "Windows 98");
        params.put("idNumber", "3301234565");
        params.put("idConclusion", "Всё плохо");
        params.put("idFirstNamePadeg", "С.В. Барышниковым");
        params.put("idSecondNamePadeg", "А.Ю. Милинским");
        params.put("idThirdNamePadeg", "А.С. Матевосян");
```

---

### Шаг 3

Создать объект класса Generator передав в конструктор путь к шаблону и мапу

```java
        Generator generator = new Generator("Template.docx", params);
```

---

### Шаг 4

Вызвать один единственный рабочий метод у объекта обработав исключения

```java
        try {
            generator.write();
        } catch (Exception e) {
            e.printStackTrace();
        }
```

---

### Шаг 5

???

---

### Шаг 6

Profit

---

P.S. Имя файла по умолчанию дата и время, но можно дать и свое
Пример:
```java
    generator.setNameOfFile(params.get("idNumber"));
```