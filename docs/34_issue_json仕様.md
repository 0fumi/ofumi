# issue.json仕様

## 目的

`issue.json` は、その日の「御文」を表現するデータである。

Scout・Editor・Reviewer・Androidアプリは、すべてこのフォーマットを共通仕様として利用する。

---

# 設計方針

## 🚀 v1

1日につき1ファイルを生成する。

```text
content/

└── issues/
    ├── latest.json
    ├── 2026-08-01.json
    ├── 2026-08-02.json
    └── ...
```

Androidアプリは通常 `latest.json` を取得する。

---

# 全体構造

```json
{
  "date": "",
  "headline": "",
  "summary": [],
  "dailyAction": "",
  "articles": []
}
```

---

# date

発行日。

例

```json
"date": "2026-08-01"
```

---

# headline

ホーム画面に表示する「今日のひとこと」。

例

```json
"headline": "AIは書くから働くへ。"
```

---

# summary

今日のサマリ。

ホーム画面では3行程度で表示する。

各要素が1行として扱われる。

例

```json
"summary": [
  "AI活用はツール導入から仕事の再設計へ。",
  "複数企業で運用事例が公開され始めた。",
  "今日はAIとの協働方法を考える。"
]
```

---

# dailyAction

今日の一歩。

その日の御文を読み終えたあと、読者に試してほしい行動を一つ提案する。

例

```json
"dailyAction": "次のPRでAIにレビュー観点を聞いてみる。"
```

---

# articles

その日の掲載記事一覧。

v1では最大3件とする。

```json
"articles": [
  { ... },
  { ... },
  { ... }
]
```

---

# Article

各記事は以下の情報を持つ。

```json
{
  "id": "",
  "title": "",
  "badge": "",
  "theme": "",
  "editorComment": "",
  "summary": "",
  "whyImportant": "",
  "qaApplication": "",
  "source": {
    "title": "",
    "url": ""
  }
}
```

---

## id

記事ID。

その日の誌面内で一意となる値。

例

```json
"id": "article-1"
```

---

## title

記事タイトル。

ホーム画面・記事詳細画面で表示する。

---

## badge

記事の位置付け。

使用する値は以下の3種類。

* `NEW`
* `FOLLOW_UP`
* `TREND`

---

## theme

記事テーマ。

例

```json
"theme": "AIレビュー運用"
```

---

## editorComment

編集部コメント。

この記事を掲載した理由や背景を伝える。

---

## summary

記事の要約。

3〜5行程度で内容を整理する。

---

## whyImportant

「なぜ重要？」

仕事や開発現場へどのような影響があるかを編集部の視点で解説する。

---

## qaApplication

「仕事へ持ち帰る」。

読者が明日から仕事で活用できる考え方や実践例をまとめる。

---

## source

原文情報。

```json
{
  "title": "Shopify Engineering",
  "url": "https://..."
}
```

Androidアプリでは「原文を読む」で利用する。

---

# バリデーション

`issue.json` は以下を満たす。

* `date` は必須
* `headline` は必須
* `summary` は3件
* `dailyAction` は必須
* `articles` は1〜3件
* `source.url` は HTTPS
* `badge` は定義済みの値のみ

---

# サンプル

```json
{
  "date": "2026-08-01",
  "headline": "AIは書くから働くへ。",
  "summary": [
    "AI活用はツール導入から仕事の再設計へ。",
    "複数企業で運用事例が公開され始めた。",
    "今日はAIとの協働方法を考える。"
  ],
  "dailyAction": "次のPRでAIにレビュー観点を聞いてみる。",
  "articles": [
    {
      "id": "article-1",
      "title": "AIレビュー運用を公開",
      "badge": "TREND",
      "theme": "AIレビュー運用",
      "editorComment": "AIを導入するだけではなく、レビュー工程そのものが変わり始めている。",
      "summary": "複数企業がAIレビューの運用事例を公開した。",
      "whyImportant": "レビューの役割が人からAIとの協働へ変化している。",
      "qaApplication": "まずはPRレビュー観点をAIと一緒に作成してみる。",
      "source": {
        "title": "Example Engineering",
        "url": "https://example.com"
      }
    }
  ]
}
```

---

# 🌱 Future

## シリーズ対応

記事にシリーズ情報を追加する。

```json
"series": {
  "title": "AIレビュー運用",
  "current": 2,
  "total": 4
}
```

---

## 添え書き

読者が記事ごとにメモを残せる機能を追加する。

Androidローカルストレージへ保存する。

---

## タグ

記事にカテゴリ情報を追加する。

例

* QA
* Android
* AI
* DevOps

---

## 多言語対応

日本語以外の誌面を配信できるよう、言語情報を追加する。

---

# 完成条件

`issue.json` は以下を満たす。

* その日の御文を1ファイルで表現できる
* Scout・Editor・Reviewer・Androidアプリで共通利用できる
* AndroidアプリがこのJSONだけで誌面を表示できる
* 将来の機能追加にも対応しやすい構造になっている
