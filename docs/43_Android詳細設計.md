# 詳細設計

## 目的

Androidアプリは、編集部が制作した「今日の御文」を読者へ届けるための閲覧アプリである。

アプリの役割は、

> 今日読むべき技術情報を、迷わず気持ちよく読める状態にすること
> 

である。

---

# 設計方針

## 🚀 v1

読書体験を優先する。

作らないもの：

- ログイン
- ユーザー管理
- 保存機能
- コメント
- 検索
- 通知
- ランキング

---

# 技術構成

## 言語

Kotlin

---

## UI

Jetpack Compose

理由：

- 宣言的UIで画面構築しやすい
- 雑誌のような表現と相性が良い
- 少ないコードで変更できる

---

## アーキテクチャ

採用：

MVVM

---

# 全体構成

```
Android App

├── UI
│
├── ViewModel
│
├── Repository
│
└── Data Source
        │
        ▼
     御文JSON
```

---

# パッケージ構成

```
com.ofumi

├── app
│
├── data
│   ├── model
│   ├── repository
│   └── datasource
│
├── domain
│
├── ui
│   ├── home
│   ├── detail
│   └── component
│
└── navigation
```

---

# Data層

## model

JSONデータを表現する。

例：

```
OfumiIssue

├── IssueInfo
├── Article
└── Metadata
```

---

## datasource

データ取得担当。

v1：

```
JsonDataSource

↓

GitHub上のJSON
```

---

## repository

UIへデータを渡す。

役割：

- データ取得
- エラー処理
- データ変換

---

# Domain層

ビジネスルール。

v1では最小。

例：

- 今日の御文取得
- 記事一覧取得

---

# UI層

## 画面一覧

```
Screen

├── HomeScreen
└── ArticleDetailScreen
```

---

# 🏠 HomeScreen詳細

## 目的

今日の御文を表紙として表示する。

---

## 入力

```
OfumiIssue
```

---

## 状態

```
HomeUiState

├── Loading
├── Success
└── Error
```

---

## UI構成

```
HomeScreen

├── HeaderSection
│
├── HeadlineSection
│
├── SummarySection
│
├── ArticleListSection
│
└── TakeawaySection
```

---

# HeaderSection

表示：

- 御文ロゴ
- 日付

役割：

雑誌の表紙感。

---

# HeadlineSection

表示：

今日のひとこと。

最重要エリア。

---

# SummarySection

表示：

今日のサマリ。

3行程度。

---

# ArticleListSection

表示：

記事3本。

Component：

```
ArticleCard
```

---

## ArticleCard

表示：

- 番号
- タイトル
- バッジ
- 一言

操作：

タップ

↓

詳細画面

---

# TakeawaySection

表示：

今日の一歩。

---

# 📖 ArticleDetailScreen詳細

## 目的

記事を仕事へ持ち帰る場所。

---

## 入力

```
Article
```

---

## 状態

```
DetailUiState

├── Loading
├── Success
└── Error
```

---

## UI構成

```
ArticleDetailScreen

├── TitleSection
├── BadgeSection
├── EditorCommentSection
├── SummarySection
├── WhyImportantSection
├── WorkApplicationSection
├── TodayActionSection
└── OriginalLinkSection
```

---

# Navigation

v1はシンプル。

```
Home

 ↓

Detail

 ↓

Browser
```

---

## Navigation方式

Jetpack Navigation Compose

---

# データ更新

## 🚀 v1

アプリ起動時に取得。

流れ：

```
App起動

↓

JSON取得

↓

Repository

↓

ViewModel

↓

Compose表示
```

---

# エラー処理

## JSON取得失敗

表示：

```
御文を取得できませんでした。

時間を置いて再度お試しください。
```

---

## 記事なし

表示：

```
本日の御文を準備中です。
```

---

# テーマ設計

## v1

固定テーマ。

例：

- 背景
- 文字
- 余白

---

## Future

- ダークモード
- 季節テーマ
- 特集デザイン

---

# 🌱 Future

## 過去号

追加：

```
ArchiveScreen
```

---

## 添え書き

追加：

```
NoteScreen
```

---

## 個人化

追加：

- ログイン
- 推薦
- 本棚

---

# 完成条件

Androidアプリは、

- 起動すると今日の御文が読める
- ホームから記事詳細へ移動できる
- JSONだけで内容更新できる
- 無料構成で運用できる
- 毎朝読む体験を邪魔しない

ことを満たす。