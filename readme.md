## Задача 1
### Этап 1
Создайте пустой git-репозиторий.

Создайте ветку `hw1` и переключитесь на неё.

В репозитории создайте мультимодульный maven-проект со следующей структурой:
```
/project
├─ bot/
│ ├─ pom.xml
├─ link-parser/
│ ├─ pom.xml
├─ scrapper/
│ ├─ pom.xml
├─ pom.xml
```
Проверьте, что команда mvn package успешно отрабатывает в терминале.

### Этап 2

Добавьте зависимости *spring-cloud=2022.0.0* и *spring-boot=3.0.1* в секцию <dependencyManagement> в  корневом pom.xml:

```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-dependencies</artifactId>
    <version>${spring-cloud.version}</version>
    <type>pom</type>
    <scope>import</scope>
</dependency>

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-dependencies</artifactId>
  <version>${spring-boot.version}</version>
  <type>pom</type>
  <scope>import</scope>
</dependency>
```
В модулях `bot` и `scrapper` сконфигурируйте запуск плагинов в секции `<build>`.
Подсказка: для наследования конфигурации можно использовать <pluginManagement> в корневом pom.xml
```
<plugin>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-maven-plugin</artifactId>
  <version>${spring-boot.version}</version>
  <configuration>
      <layers>
          <enabled>true</enabled>
      </layers>
      <excludes>
          <exclude>
              <groupId>org.projectlombok</groupId>
              <artifactId>lombok</artifactId>
          </exclude>
      </excludes>
  </configuration>
  <executions>
      <execution>
          <goals>
              <goal>repackage</goal>
              <goal>build-info</goal>
          </goals>
      </execution>
  </executions>
</plugin>
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-compiler-plugin</artifactId>
  <version>${maven-compiler-plugin.version}</version>
  <configuration>
      <release>17</release>
      <parameters>true</parameters>
  </configuration>
</plugin>
```
### Этап 3
Подключите в модуле `bot` и `scrapper` зависимости `spring-boot-starter-web` и `spring-boot-starter-validation`.

Дополнительно подключите  перечисленные вспомогательные технические зависимости:
```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
  <scope>runtime</scope>
  <optional>true</optional>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-configuration-processor</artifactId>
  <optional>true</optional>
</dependency>
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-context-indexer</artifactId>
  <optional>true</optional>
</dependency>
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <optional>true</optional>
</dependency>
```
Дополнительно добавьте зависимость *org.jetbrains:annotations:23.1.0* в корневой `pom.xml` со `scope=provided`.

Проверьте, что команда mvn compile успешно отрабатывает в терминале.

### Этап 4
Создайте record с конфигурацией в пакетах `ru.tinkoff.edu.java.scrapper.configuration` и `ru.tinkoff.edu.java.bot.configuration`:
```
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
```

Создайте классы `ScrapperApplication` и `BotApplication` с методом `main` в модуле `scrapper` в пакетах `ru.tinkoff.edu.java.scrapper` и `ru.tinkoff.edu.java.bot` соответственно:

```
@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class *Application {
    public static void main(String[] args) {
        var ctx = SpringApplication.run(ScrapperApplication.class, args);
        ApplicationConfig config = ctx.getBean(ApplicationConfig.class);
        System.out.println(config);
    }
}
```
Перед запуском внесите в `application.properties/yaml` ключ `app.test` с произвольным значением.

Проверьте что класс запускается, и что команда `mvn package` успешно отрабатывает в терминале.