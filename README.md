**Nama**: Alyssa Layla Sasti  
**Kelas**: AdPro B  
**NPM**: 2306152052

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
