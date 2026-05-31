# 🇮🇩 Indonesian IPTV Extension for CloudStream

Extension CloudStream yang menyediakan **69 channel TV Indonesia** langsung dari player CloudStream, lengkap dengan navigasi channel tanpa keluar dari tayangan.

## ✨ Fitur

| Fitur | Keterangan |
|-------|-----------|
| 📺 **69 Channel** | 6 kategori: Nasional, Berita, Olahraga, Anak, Religi, Daerah |
| 🔄 **Navigasi Channel** | Ganti channel dengan tombol ◀ ▶ tanpa keluar player |
| 🖼️ **Logo Channel** | Setiap channel punya logo sendiri |
| 📡 **HLS Stream** | Semua sumber menggunakan HLS |
| 📱 **CloudStream Native** | Full integration dengan CloudStream |

## 📡 Daftar Channel

| # | Channel | Kategori |
|---|---------|----------|
| 1 | TVRI Nasional | 🇮🇩 Nasional |
| 2 | TVRI World | 🇮🇩 Nasional |
| 3 | RCTI | 🇮🇩 Nasional |
| 4 | SCTV | 🇮🇩 Nasional |
| 5 | Indosiar | 🇮🇩 Nasional |
| 6 | ANTV | 🇮🇩 Nasional |
| 7 | Trans TV | 🇮🇩 Nasional |
| 8 | Trans7 | 🇮🇩 Nasional |
| 9 | Metro TV | 🇮🇩 Nasional |
| 10 | tvOne | 🇮🇩 Nasional |
| 11 | BTV | 🇮🇩 Nasional |
| 12 | MDTV | 🇮🇩 Nasional |
| 13 | MOJI | 🇮🇩 Nasional |
| 14 | Magna Channel | 🇮🇩 Nasional |
| 15 | Nusantara TV | 🇮🇩 Nasional |
| 16 | Garuda TV | 🇮🇩 Nasional |
| 17 | VTV | 🇮🇩 Nasional |
| 18 | Kompas TV | 📰 Berita |
| 19 | CNN Indonesia | 📰 Berita |
| 20 | CNBC Indonesia | 📰 Berita |
| 21 | iNews | 📰 Berita |
| 22 | IDTV | 📰 Berita |
| 23 | Metro Globe Network | 📰 Berita |
| 24 | BeritaSatu | 📰 Berita |
| 25 | Jakarta Globe News | 📰 Berita |
| 26 | BN Channel | 📰 Berita |
| 27 | TVRI Sport | ⚽ Olahraga |
| 28 | SPOTV | ⚽ Olahraga |
| 29 | SPOTV2 | ⚽ Olahraga |
| 30 | Motorvision TV | ⚽ Olahraga |
| 31 | RTV | 🧒 Anak |
| 32 | Biznet Kids | 🧒 Anak |
| 33 | My Kidz | 🧒 Anak |
| 34 | Animax | 🧒 Anak |
| 35 | Rodja TV | 🕌 Religi |
| 36 | DAAI TV | 🕌 Religi |
| 37 | RRI Net | 🕌 Religi |
| 38 | TV Mu | 🕌 Religi |
| 39 | Surau TV | 🕌 Religi |
| 40 | Al Iman TV | 🕌 Religi |
| 41 | Salam TV | 🕌 Religi |
| 42 | MQTV | 🕌 Religi |
| 43 | WesalTV | 🕌 Religi |
| 44 | AshillTV | 🕌 Religi |
| 45 | TV MUI | 🕌 Religi |
| 46 | JTV | 🏙️ Daerah |
| 47 | JAKTV | 🏙️ Daerah |
| 48 | Jowo Channel | 🏙️ Daerah |
| 49 | Elshinta TV | 🏙️ Daerah |
| 50 | TVKU | 🏙️ Daerah |
| 51 | Surabaya TV | 🏙️ Daerah |
| 52 | Stara TV | 🏙️ Daerah |
| 53 | Jawa Pos TV | 🏙️ Daerah |
| 54 | Jogja Istimewa TV | 🏙️ Daerah |
| 55 | Semarang TV | 🏙️ Daerah |
| 56 | PJTV | 🏙️ Daerah |
| 57 | Caruban TV | 🏙️ Daerah |
| 58 | Dhoho TV | 🏙️ Daerah |
| 59 | Nasional TV | 🏙️ Daerah |
| 60 | Madu TV | 🏙️ Daerah |
| 61 | Bandung TV | 🏙️ Daerah |
| 62 | Jogja TV | 🏙️ Daerah |
| 63 | Banjar TV | 🏙️ Daerah |
| 64 | RCTV | 🏙️ Daerah |
| 65 | Banten TV | 🏙️ Daerah |
| 66 | Kilisuci TV | 🏙️ Daerah |
| 67 | BMS TV | 🏙️ Daerah |
| 68 | TATV | 🏙️ Daerah |
| 69 | Dhamma TV | 🏙️ Daerah |

## 📲 Instalasi

1. Buka **CloudStream**
2. **Settings → Extensions → Add Repository**
3. Masukkan URL repositori:
   ```
   https://raw.githubusercontent.com/Gintama4141/IPTV-extension/main/repo.json
   ```
4. Install **Indonesian IPTV**

Atau gunakan shortcode: (sesuai ketersediaan di CloudStream)

## 🛠️ Build Lokal

```bash
git clone https://github.com/Gintama4141/IPTV-extension.git
cd IPTV-extension
./gradlew IndonesianIPTVProvider:make
```

## 📦 Build Output

Hasil build otomatis melalui **GitHub Actions** dan dipush ke branch `builds`:
- `IndonesianIPTVProvider.cs3`
- `plugins.json`

## 📚 Sumber Stream

- [iptv-org/iptv](https://github.com/iptv-org/iptv)
- [mgi24/tvdigital](https://github.com/mgi24/tvdigital)
- [riotryulianto/iptv-playlists](https://github.com/riotryulianto/iptv-playlists)
- [alkhalifitv/TV](https://github.com/alkhalifitv/TV)
- [dens.tv](https://dens.tv)

## 📄 Lisensi

Public Domain — Gunakan dengan bijak.
