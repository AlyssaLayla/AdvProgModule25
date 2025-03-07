**Nama**: Alyssa Layla Sasti  <br /> 
**Kelas**: AdPro B  <br />
**NPM**: 2306152052 <br />
## Link Deployment:
https://armed-adelaida-alyssalayla-573dd321.koyeb.app

<details>
<summary><b>REFLECTION MODULE 4</b></summary>
You have followed the Test-Driven Development workflow in the Exercise. Now answer these questions:

1. Reflect based on Percival (2017) proposed self-reflective questions (in “Principles and Best Practice of Testing” submodule, chapter “Evaluating Your Testing Objectives”), whether this TDD flow is useful enough for you or not. If not, explain things that you need to do next time you make more tests.
    TDD merupakan prinsip yang sangat penting dan bagus untuk diterapkan dalam programming. Namun, bagi saya pribadi, terkadang saya sedikit kebingungan untuk memulai membuat program dikarenakan saya terbiasa untuk memulai dari kode program dulu baru masuk ke testing. 
    Namun, saya sadari bahwa cara lama saya tidaklah efisien dikarenakan shearusnya test yang menjadi standar untuk kode yang kita buat, bukan sebaliknya.

2.  You have created unit tests in Tutorial. Now reflect whether your tests have successfully followed F.I.R.S.T. principle or not. If not, explain things that you need to do the next time you create more tests.
    Saya sudah menerapakan F.I.R.S.T principle dengan cukup baik. Di mana saya sudah menggunakan RED, GREEN, dan REFACTOR pada kode saya sesuai dengan class class yang ada. Namun, tetap perlu pengembangan dalam kode saya sebagai contoh, untuk paymentMethod sebenarnya
    masih bisa untuk di REFACTOR menjadi enum sehingga lebih rapi. Juga sepertinya masih ada beberapa kode yang bisa diREFACTOR agar lebih baik. Namun secara keseluruhan, saya rasa saya sudah cukup menerapkan prinsip ini dengan baik, hanya perlu finishing yang lebih rapi.
</details>

<details>
<summary><b>REFLECTION MODULE 3</b></summary>
Apply the SOLID principles you have learned. You are allowed to modify the source code according to the principles you want to implement. Please answer the following questions: 

1. Explain what principles you apply to your project!
    - Single Responsibility Principle (SRP)
        Saya memindahkan `CarController` yang tadinya berada dan extends dengan `ProductController` menjadi file terpisah khusus `CarController`. 
        Hal ini dikarenakan keduanya memiliki fungsi yang berbeda dan tidak perlu untuk dihubungkan dengan inheritance. Lebih baik apabila dibuat
        file terpisah saja agar setiap class memiliki satu tanggung jawab sesuai prinsip SRP.
    - Open-Closed Principle(OCP)
        Kode saya sudah menerapkan Open-Closed Principle yaitu open for extension and closed for modification. Hal ini dapat dilihat dari adanya controller yang memungkinkan 
        adanya penambahan routes tanpa mengubah fungsionalitas yang ada. Juga dengan adanya perubahan pada `CarContoller` yang mana mengubah data types untuk `carService` dari
        `CarServiceImpl` menjadi interface `CarService`.
    - Liskov Substitution Principle
        Memindahkan `CarController` menjadi independent class merupakan salah satu penerapan LSP. Dikarenakan fungsi dan cara kerja yang dimiliki `CarController` berbeda dengan
        `ProductController`. Jika `CarController` menjadi subclass dari `ProductController` ini tidak sesuai dengan prinsip LSP juga.
    - Interface Segregation Principle (ISP)
         Program yang sudah dibuat telah menerapkan ISP. Hal ini dapat dilihat dari interface yang ada dibuat spesifik sesuai tugasnya dan method yang ada pun spesifik sesuai 
         kebutuhan pada class tersebut.
    - Dependency Inversion Principle (DIP)
         Prinsip DIP mengatakan bahwa ketergantungan lebih baik ditujukan ke suatu interface class dibanding ke concrete class. Dengan mengganti data types `CarSeviceImpl` 
         menjadi `CarService` merupakan penerapan yang saya lakukan. Dikarenakan saya menujukan ketergantungan ke interface class yang bersifat abstract dibanding ditujukan ke kelas yang bersifat concrete

2.  Explain the advantages of applying SOLID principles to your project with examples.
    Dengan menggunakan SOLID, kita dapat meningkatkan efektivitas, keterbacaan, efisiensi, dan fleksibilitas dalam pengerjaan kode. Kode kita juga menjadi lebih mudah dipahami sehingga memudahkan apabila adanya
    modifikasi oleh suatu tim dengan jumlah programmer lebih dari satu orang. Kemudian juga SOLID membuat projek kita menjadi maintainable, sehingga mudah apabila projek ditujukan untuk jaga panjang, lebih mudah 
    dan cepat apabila ingin dilakukan suatu pengembangan atau penambahan fitur pada projek tersebut. Contoh pada projek saya adalah pemisahan `CarController` yang awalnya berada di dan extends `ProductController`
    menjadi class independent sendiri. Kemudian perubahan penggunaan `CarServiceImpl` menjadi `CarService` saja agar ketergantungan menuju ke abstract class bukan concrete class.

3. Explain the disadvantages of not applying SOLID principles to your project with examples.
    Dengan tidak menggunakan SOLID, kode akan menjadi fragile, tidak fleksibel, tidak mudah untuk dimodifikasi, readibility menurun, dan tidak maintainable. Sehingga secara umum ini akan menurunkan kualitas kode dan
    produktivitas dari programmernya. Seperti misalnya pada kode saya, awalnya `CarController` berada pada file dan extends `ProductController`. Hal ini mengakibatkan apabila kita ingin memodifikasi salah satu objek controller saja,
    maka akan mempengaruhi yang lain. Dengan posisi awalnya `CarController` merupakan subclass dari `ProductController` memberikan dependensi satu sama lain yang tidak diperlukan. Ini contoh bawah dengan tidak adanya SOLID 
    membuat kode menjadi tidak maintainable. Sebenarnya sangat lebih baik apabila kedua contoller tersebut dipisah seperti yang sudah saya lakukan di branch after-solid agar menerapkan SRP. 
</details>

<details>
<summary><b>REFLECTION MODULE 2</b></summary>


You have implemented a CI/CD process that automatically runs the test suites, analyzes code quality, and deploys to a PaaS. 
Try to answer the following questions in order to reflect on your attempt completing the tutorial and exercise.

1. List the code quality issue(s) that you fixed during the exercise and explain your strategy on fixing them.
   - Remove unnecessary public modifier pada file `ProductService.java`
      Pada awalnya saya memberikan modifier public untuk method `create()`, `findAll()`, `delete()`, `findById()`, dan `edit()`.
      Namun, hal ini tidak diperlukan karena secara default Java sudah mengatur modifier pada method dalam interface. Maka dari itu,
      saya menghilangkan modifier public pada kelima method tersebut.
   - Change unused import with the spesific import pada file `ProductController.java`
      Sebelumnya, di file ini terdapat baris yang tertanda sebagai unused import yaitu `import org.springframework.web.bind.annotation.*`.
      Setelah saya lihat kembali, sebenarnya import pada baris ini bukan tidak digunakan, namun karena baris tersebut melakukan import terhadap 
      semua elemen yang dibutuhkan pula pada kode saya, sehingga kurang spesifik dalam meng-importnya. Maka dari itu, baris import ini saya
      hilangkan dan saya ganti dengan import secara spesifik, yaitu:
      ```angular2html
              import org.springframework.web.bind.annotation.RequestMapping;
              import org.springframework.web.bind.annotation.GetMapping;
              import org.springframework.web.bind.annotation.PostMapping;
              import org.springframework.web.bind.annotation.ModelAttribute;
              import org.springframework.web.bind.annotation.PathVariable;
      ```
   - Melengkapi unit test coverage hingga 100%. 
     - Menambahkan unit test untuk main methods di `EshopApplicationTests`
       Permasalahan pada poin ini adalah, sebelumnya saya hanya membuat unit test untuk mengecek adanya class EshopApplication tanpa membuat unit test untuk cek
       saat dia run. Maka dari itu, saya menambahkkan unit `mainMethodRuns()`.
     - Menambahkan unit test untuk `productId` dan `findById` di `ProductRepositoryTest`
       Permasalahan pada poin ini adalah, sebelumnya saya sudah membuat unit test untuk mengecek pembuatan produk dengan productId. Namun, saya belum mempunyai unit
       test untuk mengecek pembuatan produk ketika tidak ada productId untuk mengecek fungsi `create` apabila productId nya null maka akan auto generate dari
       `UUID.randomUUID()`. Juga, pada module sebelumnya saya belum menambahkan unit test untuk findById. Maka dari itu, saya menambahkan unit test `testCreateWithoutProductId()`
       dan `testFindByIdOfTwoProducts()`
     - Menambahkan `ProductServiceImplTest.java` dan melengkapi unit test untuk `ProductServiceImpl.java`
       Pada module sebelumnya, saya belum membuat unit test untuk meng-cover file ProductServiceImpl.java. Maka dari itu, saya membuat direktori `service` pada bagian test
       dan membuat `testCreate()`, `testFindAll()`, `testDelete()`, `testFindById()`, dan `testEdit()` untuk unit test pada semua method yang ada di `ProductServiceImpl.java`
     - Menambahkan `ProductControllerTest.java` dan `HomePageControllerTest`pada direktori `controller` pada direktori test dengan menggunakan `testing using mock`
     
2. Look at your CI/CD workflows (GitHub)/pipelines (GitLab). Do you think the current implementation has met the definition of Continuous Integration and Continuous Deployment? Explain the reasons (minimum 3 sentences)!
    Implementasi yang telah saya lakukan pada module 2 ini sudah sesuai dengan standar Continuous Integration dan Continuous Deployment karena proses otomasi sudah berjalan dari awal pengujian hingga deployment.
    Ada 3 file yang membantu workflows CI/CD ini, diantaranya adalah `ci.yml` yang bertugas menjalankan unit test setiap ada push atau pull request, dilanjutkan dengan `pmd.yml` yang bertugas untuk melakukan review pada kode,
    dan yang terakhir ada `scorecard.yml` yang bertugas untuk melakukan analisis menjaga keamanan kode. Apabila ada kesalahan pada kode kita, unit test akan memberikan report via JaCoCo. Umpan balik akan dilakukan secara otomatis
    sehingga proses deployment tidak akan terlaksana semisal tahap - tahap sebelumnya masih terdapat error. Apabila semuanya sudah sesuai standar, proses build dan deployment akan dilakukan di `Koyeb` secara otomatis dan website dapat terdeploy.

</details>

<details>
<summary><b>REFLECTION MODULE 1</b></summary>


# Reflection 1

Pada tutorial ini, saya belajar banyak mengenai clean code principles dan secure coding practices. Saya telah menerapkan beberapa clean code pada kode saya, di antaranya adalah penamaan yang jelas dan meaningful, sesuai dengan fungsinya. Saya juga menambahkan penulisan eksplisit mengenai penamaan variabel ini untuk apa, seperti contoh `deleteProductPost`, yang mana ini adalah nama method untuk delete product dengan method POST.

Saya juga menerapkan prinsip fungsi lebih baik tidak terlalu panjang, *do one thing*, dan penamaan yang deskriptif. Untuk secure coding practices, saya telah menerapkan penggunaan UUID sehingga Id menjadi unik, null checks, error handling apabila null, penggunaan POST dan GET sesuai dengan kebutuhan.

Untuk hal yang dapat dikembangkan, dimulai dari handling untuk validasi user input untuk mencegah ancaman-ancaman siber. Kemudian, penanganan error dan feedback kepada pengguna juga dapat saya terapkan lebih baik lagi di kode saya.

---

# Reflection 2

## Nomor 1

Setelah saya belajar membuat unit testing, saya menyadari bahwa unit testing mempermudah proses debugging. Sehingga pembuat kode dapat menemukan error dengan lebih mudah. Menurut saya pula, dalam satu class, banyaknya unit testing yang dibuat harus disesuaikan dengan kebutuhannya dan seberapa banyak kemungkinan input/output yang dapat terjadi. Semakin banyak unit testing dan semakin tinggi coverage unit testing-nya semakin baik.

Kemudian, menjawab pertanyaan terakhir, kode yang memiliki 100% unit testing code coverage tidak menentukan bahwa kode tersebut terhindar total dari bugs dan errors. Hal ini tergantung dari seberapa beragam unit testing tersebut menguji kodenya. Apabila unit-testing yang dibuat belum mengcover suatu bug, maka terhitungnya code coverage terhadap unit testing tetap 100%.

## Nomor 2

Menurut saya, apabila suatu functional test suite baru sudah dibuat, tidak akan membuat logic kodenya menjadi salah. Namun, kita harus berhati-hati agar tidak menyalahi aturan dari principles of clean code. Apabila kita membuat functional test suite baru, akan rawan terjadi duplikasi kode. Maka dari itu, kita dapat membuat functional test yang di-parameterize sehingga dapat dipakai berkali-kali sesuai dengan fungsinya agar dapat didaur ulang.
</details>