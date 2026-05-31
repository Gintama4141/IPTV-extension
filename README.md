# 🇮🇩 Indonesian IPTV Extension for CloudStream

Extension CloudStream yang menyediakan **68 channel TV Indonesia** langsung dari player CloudStream, lengkap dengan navigasi channel tanpa keluar dari tayangan.

## ✨ Fitur

| Fitur | Keterangan |
|-------|-----------|
| 📺 **68 Channel** | 6 kategori: Nasional, Berita, Olahraga, Anak, Religi, Daerah |
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
| 34 | Rodja TV | 🕌 Religi |
| 35 | DAAI TV | 🕌 Religi |
| 36 | RRI Net | 🕌 Religi |
| 37 | TV Mu | 🕌 Religi |
| 38 | Surau TV | 🕌 Religi |
| 39 | Al Iman TV | 🕌 Religi |
| 40 | Salam TV | 🕌 Religi |
| 41 | MQTV | 🕌 Religi |
| 42 | WesalTV | 🕌 Religi |
| 43 | AshillTV | 🕌 Religi |
| 44 | TV MUI | 🕌 Religi |
| 45 | JTV | 🏙️ Daerah |
| 46 | JAKTV | 🏙️ Daerah |
| 47 | Jowo Channel | 🏙️ Daerah |
| 48 | Elshinta TV | 🏙️ Daerah |
| 49 | TVKU | 🏙️ Daerah |
| 50 | Surabaya TV | 🏙️ Daerah |
| 51 | Stara TV | 🏙️ Daerah |
| 52 | Jawa Pos TV | 🏙️ Daerah |
| 53 | Jogja Istimewa TV | 🏙️ Daerah |
| 54 | Semarang TV | 🏙️ Daerah |
| 55 | PJTV | 🏙️ Daerah |
| 56 | Caruban TV | 🏙️ Daerah |
| 57 | Dhoho TV | 🏙️ Daerah |
| 58 | Nasional TV | 🏙️ Daerah |
| 59 | Madu TV | 🏙️ Daerah |
| 60 | Bandung TV | 🏙️ Daerah |
| 61 | Jogja TV | 🏙️ Daerah |
| 62 | Banjar TV | 🏙️ Daerah |
| 63 | RCTV | 🏙️ Daerah |
| 64 | Banten TV | 🏙️ Daerah |
| 65 | Kilisuci TV | 🏙️ Daerah |
| 66 | BMS TV | 🏙️ Daerah |
| 67 | TATV | 🏙️ Daerah |
| 68 | Dhamma TV | 🏙️ Daerah |

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
