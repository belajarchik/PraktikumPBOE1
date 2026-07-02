-- ============================================================
-- Setup Database untuk Praktikum 10 - Akses Basis Data
-- Jalankan script ini di MySQL sebelum menjalankan program Java
-- ============================================================

-- 1. Buat database
CREATE DATABASE IF NOT EXISTS jdbc_mhs
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

-- 2. Gunakan database
USE jdbc_mhs;

-- 3. Buat tabel mahasiswa
--    id   : INT(11), Primary Key, Not Null, Auto Increment
--    nama : VARCHAR(20), Not Null
CREATE TABLE IF NOT EXISTS mahasiswa (
    id   INT(11)     NOT NULL AUTO_INCREMENT,
    nama VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 4. Buat user untuk akses (opsional, sesuaikan dengan konfigurasi lokal)
--    Jalankan bagian ini hanya jika user 'student' belum ada
-- CREATE USER 'student'@'localhost' IDENTIFIED BY 'rahasia';
-- GRANT ALL PRIVILEGES ON jdbc_mhs.* TO 'student'@'localhost';
-- FLUSH PRIVILEGES;

-- 5. Verifikasi struktur tabel
DESCRIBE mahasiswa;

-- ============================================================
-- Isi data awal untuk pengujian (opsional)
-- ============================================================
-- INSERT INTO mahasiswa (nama) VALUES ('Nina');
-- INSERT INTO mahasiswa (nama) VALUES ('Rudi');
-- INSERT INTO mahasiswa (nama) VALUES ('Beni');
-- SELECT * FROM mahasiswa;
