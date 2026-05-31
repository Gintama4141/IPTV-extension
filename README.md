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
| 16 | VTV | 🇮🇩 Nasional |
| 17 | Kompas TV | 📰 Berita |
| 18 | CNN Indonesia | 📰 Berita |
| 19 | CNBC Indonesia | 📰 Berita |
| 20 | IDTV | 📰 Berita |
| 21 | Metro Globe Network | 📰 Berita |
| 22 | BeritaSatu | 📰 Berita |
| 23 | Jakarta Globe News | 📰 Berita |
| 24 | TVRI Sport | ⚽ Olahraga |
| 25 | SPOTV | ⚽ Olahraga |
| 26 | SPOTV2 | ⚽ Olahraga |
| 27 | RTV | 🧒 Anak |
| 28 | Biznet Kids | 🧒 Anak |
| 29 | Rodja TV | 🕌 Religi |
| 30 | DAAI TV | 🕌 Religi |
| 31 | RRI Net | 🕌 Religi |
| 32 | TV Mu | 🕌 Religi |
| 33 | Surau TV | 🕌 Religi |
| 34 | Al Iman TV | 🕌 Religi |
| 35 | Salam TV | 🕌 Religi |
| 36 | JTV | 🏙️ Daerah |
| 37 | Elshinta TV | 🏙️ Daerah |
| 38 | TVKU | 🏙️ Daerah |
| 39 | Surabaya TV | 🏙️ Daerah |
| 40 | Stara TV | 🏙️ Daerah |
| 41 | Jawa Pos TV | 🏙️ Daerah |
| 42 | Jogja Istimewa TV | 🏙️ Daerah |
| 43 | Semarang TV | 🏙️ Daerah |
| 44 | PJTV | 🏙️ Daerah |
| 45 | Caruban TV | 🏙️ Daerah |
| 46 | Dhoho TV | 🏙️ Daerah |

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
