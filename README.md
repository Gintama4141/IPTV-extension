# 🇮🇩 Indonesian IPTV Extension for CloudStream

Extension CloudStream yang menyediakan **45+ channel TV Indonesia** langsung dari player CloudStream, lengkap dengan navigasi channel tanpa keluar dari tayangan.

## ✨ Fitur

| Fitur | Keterangan |
|-------|-----------|
| 📺 **45+ Channel** | 6 kategori: Nasional, Berita, Olahraga, Anak, Religi, Daerah |
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
| 13 | Magna Channel | 🇮🇩 Nasional |
| 14 | Nusantara TV | 🇮🇩 Nasional |
| 15 | Garuda TV | 🇮🇩 Nasional |
| 16 | MNCTV | 🇮🇩 Nasional |
| 17 | VTV | 🇮🇩 Nasional |
| 18 | Kompas TV | 📰 Berita |
| 19 | CNN Indonesia | 📰 Berita |
| 20 | CNBC Indonesia | 📰 Berita |
| 21 | IDTV | 📰 Berita |
| 22 | Metro Globe Network | 📰 Berita |
| 23 | BeritaSatu | 📰 Berita |
| 24 | Jakarta Globe News | 📰 Berita |
| 25 | TVRI Sport | ⚽ Olahraga |
| 26 | SPOTV | ⚽ Olahraga |
| 27 | SPOTV2 | ⚽ Olahraga |
| 28 | RTV | 🧒 Anak |
| 29 | Biznet Kids | 🧒 Anak |
| 30 | Rodja TV | 🕌 Religi |
| 31 | DAAI TV | 🕌 Religi |
| 32 | RRI Net | 🕌 Religi |
| 33 | TV Mu | 🕌 Religi |
| 34 | Surau TV | 🕌 Religi |
| 35 | Al Iman TV | 🕌 Religi |
| 36 | Salam TV | 🕌 Religi |
| 37 | JTV | 🏙️ Daerah |
| 38 | Elshinta TV | 🏙️ Daerah |
| 39 | TVKU | 🏙️ Daerah |
| 40 | Surabaya TV | 🏙️ Daerah |
| 41 | Stara TV | 🏙️ Daerah |
| 42 | Jawa Pos TV | 🏙️ Daerah |
| 43 | Jogja Istimewa TV | 🏙️ Daerah |
| 44 | Semarang TV | 🏙️ Daerah |
| 45 | PJTV | 🏙️ Daerah |
| 46 | Caruban TV | 🏙️ Daerah |
| 47 | Dhoho TV | 🏙️ Daerah |

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
