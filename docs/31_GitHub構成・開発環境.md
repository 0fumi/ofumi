# GitHub構成・開発環境詳細設計

## 目的

御文の開発・編集・公開に必要なファイル管理方法を定義する。

GitHubを御文編集部の制作基盤として利用する。

---

# 設計方針

## 🚀 v1

シンプルな構成を優先する。

優先事項：

- 無料で運用できる
- 変更履歴が残る
- 編集と開発を分離できる
- 1人でも管理できる

---

# GitHub利用目的

GitHubは以下を管理する。

## 1. Androidアプリ

役割：

読書アプリ本体。

---

## 2. 御文データ

役割：

毎日の発行データ。

---

## 3. 編集部素材

役割：

Scout・Editor・Reviewerの成果物。

---

# Repository構成

## 🚀 v1では1 Repository

採用：

```
ofumi
```

理由：

- 管理対象が少ない
- 個人開発では分離メリットが小さい
- 無料で扱いやすい

---

# ディレクトリ構成

```
ofumi/

├── android/
│
│   └── 御文Androidアプリ
│
├── content/
│
│   ├── issues/
│   │   ├── 2026-08-01.json
│   │   └── 2026-08-02.json
│   │
│   └── articles/
│
├── scout/
│
│   ├── scripts/
│   └── output/
│
├── docs/
│
│   ├── concept.md
│   ├── guidelines.md
│   └── design/
│
└── README.md
```

---

# 各ディレクトリ

---

# 📱 android/

## 役割

Androidアプリ本体。

含むもの：

- Kotlin
- Compose
- Gradle
- テストコード

---

構成例：

```
android/

├── app/
├── build.gradle
├── settings.gradle
└── gradle/
```

---

# 📖 content/

## 役割

御文そのもの。

---

## issues/

毎日の発行データ。

例：

```
issues/

2026-08-01.json
2026-08-02.json
```

---

## articles/

将来的な記事素材管理。

v1では最小利用。

---

# 🛰️ scout/

## 役割

情報収集処理。

含むもの：

- RSS取得スクリプト
- GitHub API取得
- 出力データ

---

構成：

```
scout/

├── scripts/
│
└── output/
```

---

# 📚 docs/

## 役割

御文の設計書。

管理対象：

- コンセプト
- 編集部憲章
- ガイドライン
- 技術選定
- 設計書

---

# ブランチ戦略

## 🚀 v1

シンプル構成。

```
main
```

のみ。

---

理由：

1人開発では複雑なGit運用は不要。

---

# Commitルール

目的：

後から歴史を追えるようにする。

形式：

```
種類: 内容
```

---

例：

```
content: 2026-08-01号を追加

feature: ArticleDetail画面追加

fix: JSON読み込み修正

docs: 編集ガイドライン更新
```

---

# Issue管理

GitHub Issueを開発メモとして使う。

種類：

## 🚀 v1

実装予定。

例：

```
[Feature]
ホーム画面実装
```

---

## 🌱 Future

将来案。

例：

```
[Future]
添え書き機能
```

---

# GitHub Actions

## 🚀 v1

利用する。

用途：

- 定期処理
- ビルド確認

---

## Scout実行

```
毎朝9:00

↓

GitHub Actions

↓

Scout

↓

記事候補生成
```

---

# 公開フロー

## 御文発行

```
Editor

↓

JSON作成

↓

Git commit

↓

main更新

↓

Android取得
```

---

# 開発環境

## 必須

### Android Studio

用途：

Android開発。

---

### JDK

用途：

Kotlinビルド。

---

### Git

用途：

バージョン管理。

---

### GitHub

用途：

コード・データ管理。

---

# ローカル開発環境

```
Developer PC

↓

Git clone

↓

Android Studio

↓

Build

↓

Emulator / Device
```

---

# 無料運用確認

| 項目 | 採用 |
| --- | --- |
| GitHub | 無料 |
| GitHub Actions | 無料枠利用 |
| Firebase | 使用しない |
| Database | 使用しない |
| Server | 使用しない |
| Storage | 使用しない |

---

# 🌱 Future

## Repository分離

将来：

```
ofumi-app

ofumi-content

ofumi-editor
```

へ分離。

---

## CI/CD

追加：

- 自動ビルド
- 自動配布
- 自動テスト

---

## 編集CMS

追加：

- Web編集画面
- 管理画面

---

# 完成条件

GitHub構成は、

- Androidを管理できる
- 御文を発行できる
- 編集履歴を残せる
- 無料で継続できる
- 1人編集部として運用できる

ことを満たす。