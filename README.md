# 🇮🇩 Indonesian IPTV Extension for CloudStream

Extension CloudStream yang menyediakan **63 channel TV Indonesia** langsung dari player CloudStream, lengkap dengan navigasi channel tanpa keluar dari tayangan.

## ✨ Fitur

| Fitur | Keterangan |
|-------|-----------|
| 📺 **63 Channel** | 6 kategori: Nasional, Berita, Olahraga, Anak, Religi, Daerah |
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
| 21 | IDTV | 📰 Berita |
| 22 | Metro Globe Network | 📰 Berita |
| 23 | BeritaSatu | 📰 Berita |
| 24 | Jakarta Globe News | 📰 Berita |
| 25 | BN Channel | 📰 Berita |
| 26 | TVRI Sport | ⚽ Olahraga |
| 27 | SPOTV | ⚽ Olahraga |
| 28 | SPOTV2 | ⚽ Olahraga |
| 29 | RTV | 🧒 Anak |
| 30 | Biznet Kids | 🧒 Anak |
| 31 | Rodja TV | 🕌 Religi |
| 32 | DAAI TV | 🕌 Religi |
| 33 | RRI Net | 🕌 Religi |
| 34 | TV Mu | 🕌 Religi |
| 35 | Surau TV | 🕌 Religi |
| 36 | Al Iman TV | 🕌 Religi |
| 37 | Salam TV | 🕌 Religi |
| 38 | MQTV | 🕌 Religi |
| 39 | WesalTV | 🕌 Religi |
| 40 | AshillTV | 🕌 Religi |
| 41 | TV MUI | 🕌 Religi |
| 42 | JTV | 🏙️ Daerah |
| 43 | Elshinta TV | 🏙️ Daerah |
| 44 | TVKU | 🏙️ Daerah |
| 45 | Surabaya TV | 🏙️ Daerah |
| 46 | Stara TV | 🏙️ Daerah |
| 47 | Jawa Pos TV | 🏙️ Daerah |
| 48 | Jogja Istimewa TV | 🏙️ Daerah |
| 49 | Semarang TV | 🏙️ Daerah |
| 50 | PJTV | 🏙️ Daerah |
| 51 | Caruban TV | 🏙️ Daerah |
| 52 | Dhoho TV | 🏙️ Daerah |
| 53 | Nasional TV | 🏙️ Daerah |
| 54 | Madu TV | 🏙️ Daerah |
| 55 | Bandung TV | 🏙️ Daerah |
| 56 | Jogja TV | 🏙️ Daerah |
| 57 | Banjar TV | 🏙️ Daerah |
| 58 | RCTV | 🏙️ Daerah |
| 59 | Banten TV | 🏙️ Daerah |
| 60 | Kilisuci TV | 🏙️ Daerah |
| 61 | BMS TV | 🏙️ Daerah |
| 62 | TATV | 🏙️ Daerah |
| 63 | Dhamma TV | 🏙️ Daerah |

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
- [dens.tv](https://dens.tv)

## 📄 Lisensi

Public Domain — Gunakan dengan bijak.
