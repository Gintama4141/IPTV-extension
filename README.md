# 🇮🇩 Indonesian IPTV Extension for CloudStream

Extension CloudStream yang menyediakan **300+ FTA Live TV** dari Indonesia dan 20+ negara internasional langsung dari player CloudStream.

## 📋 Menu Provider

| # | Menu | Channel |
|---|------|---------|
| 1 | 🇮🇩 Nasional | RCTI, MNCTV, GTV, iNews, Trans TV, Trans7, SCTV, NET TV, Moji TV, Oxygen TV, ANTV, Magna Channel, Nusantara TV, Garuda TV |
| 2 | 📰 Berita | Metro TV, Kompas TV, CNN Indonesia, CNBC Indonesia, BTV, BN Channel, Jak TV, BeritaSatu, TVOne |
| 3 | 📚 Edukasi | Indonesiana TV |
| 4 | ✝️ Religi | Rodja TV, Al-Iman TV, TV MUI, Madani TV, TV Mu, DAAI TV, Astha TV, MQTV, Salam TV, Al Bahjah TV, Dhamma TV, MQ TV, Sakti TV, Arab Saudi |
| 5 | 🏘️ Daerah | Jawa Pos TV, JTV, Surabaya TV, TV9 Nusantara, Bali TV, Bandung TV, Semarang TV, SBO TV, Duta TV, RBTV Bengkulu, Palembang TV, Surau TV, Banyumas TV, Radar Tasikmalaya, TVKU, Caruban TV, Dhoho TV, Madu TV, Jogja TV, TATV, Stara TV |
| 6 | 🎭 Hiburan | RTV, Dens Food, Elshinta TV |
| 7 | 🎵 Musik | Ibiza TV, Deluxe Music, Vevo Music |
| 8 | 👶 Anak | Mentari TV, PBS Kids, Duck TV |
| 9 | ⚽ Olahraga | FIFA World Cup 1-5, Motorvision+, BEIN Sports, Real Madrid TV, Redbull TV, MLB, UFC TV |
| 10 | 🌍 International | Persiana Jr, Persiana Cinema, Discover Film, Moviesphere, Moviedome, Brat TV, Wedo TV, HG TV |
| 11 | 🇯🇵 Jepang | NHK G, NHK E, NTV, TV Asahi, TBS, TV Tokyo, Fuji TV, Tokyo MX1, Tokyo MX2, NHK World Japan |
| 12 | 🇰🇷 Korea | Arirang TV, Arirang TV UN, Arirang Radio |
| 13 | 🇹🇭 Thailand | Channel 8 (TH) |
| 14 | 🇲🇾 Malaysia | Astro Awani, RTM Asean |
| 15 | 🇧🇳 Brunei | RTB Sukmaindera, RTB Aneka, RTB Go Live |
| 16 | 🇸🇬 Singapura | Channel 5 (SG), Channel 8 (SG), Channel U |
| 17 | 🇵🇭 Filipina | GMA 7, Hope Channel PH, UNTV |

> Total 17 menu entry — channel bertambah otomatis dari M3U aggregation (iptv-org + 3 sumber Indonesia).

## ✨ Fitur

- **300+ FTA channel** dari 10 kategori Indonesia + 7 negara internasional
- **M3U Aggregation** — channel dinamis dari 4 sumber playlist
- **Channel logo** untuk setiap channel
- **HLS Stream** — semua channel menggunakan HLS
- **Paginasi** 50 channel per halaman
- **Cache 10 menit** untuk performa optimal

## 📲 Instalasi

1. Buka **CloudStream**
2. **Settings → Extensions → Add Repository**
3. Masukkan URL repositori:
   ```
   https://raw.githubusercontent.com/Gintama4141/IPTV-extension/main/repo.json
   ```
4. Install **Indonesian IPTV**

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

## 📄 Lisensi

Public Domain — Gunakan dengan bijak.
