# README — RestaurantEventConsumer

Bu sənəd `RestaurantEventConsumer` içində e‑mail göndərmə funksiyasını necə istifadə etmək və `application.yml` faylında e‑mail məlumatlarını necə konfiqurasiya etmək barədə qısa və səliqəli təlimatdır.

---

## 1. Məqsəd

`RestaurantEventConsumer` hadisəni qəbul etdikdə istifadəçiyə və ya müəyyən ünvanlara e‑mail göndərmək üçün `mailService` çağırışını ehtiva edir. Aşağıdakı nümunə göstərir necə e‑mail göndərilməsi inteqrasiya edilib.

## 2. Nümunə kod

`RestaurantEventConsumer` sinifində e‑mail göndərmə ilə bağlı hissə belə görünür:

```java
// göndərmək istədiyiniz emaili RestaurantEventConsumer içinə qeyd edin..
// log.info("mail sending -> {}", event);
//mailService.send("Godermek istdiyiniz email", event.getName(), event.getAddress());
// log.info("mail sended {}", event.getName());
```

> Qeyd: Yuxarıdakı `mailService.send(...)` çağırışında birinci parametr göndəriləcək e‑mail ünvanıdır. `event.getName()` və `event.getAddress()` isə hadisədən götürülən mətnlər/parametrlərdir — layihənizin məntiqinə görə dəyişə bilər.

## 3. `application.yml` daxilində e‑mail və şifrə təyini

E‑mail göndərmə üçün istifadə edəcəyiniz göndərən e‑mail ünvanı və ona uyğun parolu `application.yml`‑də müvafiq sahəyə əlavə edin. Məsələn:

```yaml
spring:
  mail:
    host: smtp.gmail.com
    port: 587
    username: your‑sender@example.com   # göndərən mail ünvanı
    password: "XXXXXXXXXXXXXXXX"      # göndərən mail üçün parol (aşağıdakı qeydə baxın)
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
```

### Vacib qeyd

* Əgər Gmail hesabından istifadə edirsinizsə, adi hesab parolundan fərqli olaraq **App Password** (Google tərəfindən yaradılan 16 rəqəmli tətbiq‑şifrəsi) istifadə etməlisiniz. Bu parol `password` sahəsinə yerləşdirilməlidir.
* Hesabınızda iki faktorlu təsdiq (2FA) aktivdirsə, App Password yaratmaq məcburidir. Google hesabınızın təhlükəsizlik parametrləri → "App passwords" bölməsindən 16 simvoldan ibarət parolu yaratmaq olar.
* Heç bir real parolu birbaşa versiya nəzarətində saxlamayın. Mümkünsə, parolu çevrə dəyişəni (environment variable) və ya gizli idarəetmə (secret manager) vasitəsilə ötürün.


## 4. Tez‑tez verilən suallar

**S: Parol nə qədər uzun olmalıdır?**
C: Google App Password dəqiq 16 simvoldan ibarətdir.

**S: Kod nümunəsində `%s` kimi yer tutucular varmı?**
C: Nümunədə sadəcə `mailService.send(...)` çağırışı göstərilmişdir. Öz loglarınızda `String.format` və ya logger parametrlərindən istifadə edə bilərsiniz.

---

