# Splatoon Gyakunator

YES/NO で答えられる質問をして、スプラトゥーンのブキを当てるゲームです。

## アプリ URL

https://basio0916.github.io/splatoon-gyakunator/

## 仕様技術

| カテゴリ       | 技術スタック           |
| -------------- | ---------------------- |
| フロントエンド | React, TypeScript      |
| バックエンド   | Scala, Play Framework  |
| アーキテクチャ | クリーンアーキテクチャ |
| インフラ       | GitHub Pages, Render   |
| CI/CD          | GitHub Actions         |

## ディレクトリ構造

- `backend/`: バックエンド（Scala + Play Framework）が格納されているディレクトリ
  - `app/`: ソースコードが格納されているディレクトリ
    - `adapter/`: アダプター層のディレクトリ
    - `domain/`：ドメイン層のディレクトリ
    - `infrastructure/`: インフラ層のディレクトリ
    - `usecase/`: ユースケース層のディレクトリ
  - `conf/`: Play Framework の設定ファイルが格納されているディレクトリ
  - `resources/`: データ等のリソースが格納されているディレクトリ
  - `test/`: テストコードが格納されているディレクトリ
- `frontend/`: フロントエンド（TypeScript + React）が格納されているディレクトリ
  - `src/`: ソースコードが格納されているディレクトリ
    - `components/`: React コンポーネントが格納されているディレクトリ

## 依存関係

- `sbt`
- `npm`

## サーバー起動方法

### フロントエンド

```
cd frontend
npm run dev
```

http://localhost:5173 でサーバーが立ち上がります

### バックエンド

```
cd backend
sbt run
```

http://localhost:9000 でサーバーが立ち上がります

## 環境変数

| 変数名     | 役割                   | デフォルト値 |
| ---------- | ---------------------- | ------------ |
| JWT_SECRET | JWT エンコード用秘密鍵 | secret       |
