# 🇮🇩 Indonesian IPTV Extension for CloudStream

Extension CloudStream yang menyediakan **300+ FTA Live TV** dari Indonesia dan 7 negara internasional langsung dari player CloudStream.

## 📋 Menu Provider

| # | Menu | Kategori/ Negara |
|---|------|-----------------|
| 1 | 🇮🇩 Nasional | TVRI, RCTI, MNCTV, GTV, Trans TV, Trans7, SCTV, Indosiar, NET TV, Moji, ANTV, Magna, Nusantara TV, Garuda TV |
| 2 | 📰 Berita | iNews, tvOne, Metro TV, Kompas TV, CNN Indonesia, CNBC Indonesia, Jak TV, BeritaSatu, BTV, BN Channel |
| 3 | 🎓 Edukasi | Indonesiana TV |
| 4 | 🕌 Religi | Rodja TV, Al-Iman TV, TV MUI, Madani TV, TV Mu, DAAI TV, MQTV, Salam TV, Al Bahjah TV, Dhamma TV |
| 5 | 🏘️ Daerah | 31 TVRI Regional + Jawa Pos TV, JTV, Surabaya TV, Bali TV, Bandung TV, dll |
| 6 | 🎬 Hiburan | RTV |
| 7 | 🧒 Anak | Mentari TV |
| 8 | ⚽ Olahraga | TVRI Sport |
| 9 | 🇯🇵 Jepang | NHK G, NHK E, NTV, TV Asahi, TBS, Fuji TV, TV Tokyo, Tokyo MX, NHK World |
| 10 | 🇰🇷 Korea | Arirang TV, Arirang TV UN, Arirang Radio |
| 11 | 🇹🇭 Thailand | Channel 8 |
| 12 | 🇲🇾 Malaysia | Astro Awani, RTM Asean |
| 13 | 🇧🇳 Brunei | RTB Sukmaindera, RTB Aneka, RTB Go Live |
| 14 | 🇸🇬 Singapura | Channel 5, Channel 8, Channel U |
| 15 | 🇵🇭 Filipina | GMA 7, Hope Channel PH, UNTV |

> Total 15 menu entry — channel bertambah otomatis dari M3U aggregation (iptv-org + 3 sumber Indonesia).

## ✨ Fitur

- **300+ FTA channel** dari 8 kategori Indonesia + 7 negara internasional
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
