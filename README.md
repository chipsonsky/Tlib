# Tlib

**TLib** — это небольшая утилитарная библиотека для Spigot/Paper-плагинов, созданная для упрощения работы с предметами и головами игроков.

---

## 🔧 Подключение через Maven (через JitPack)

### 1. Добавьте репозиторий JitPack в ваш `pom.xml`:

```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```
```xml
<dependency>
    <groupId>com.github.chipsonsky</groupId>
    <artifactId>Tlib</artifactId>
    <version>v1.0.0</version>
</dependency>
```

## 📚 Возможности

- 🔨 `ItemBuilder` — удобное построение `ItemStack` с поддержкой:
  - Названия и описания (lore)
  - Материала
  - Флагов предметов
  - зачарований и т.д.
  
- 🎭 `HeadBuilder` — расширяет `ItemBuilder` и позволяет:
  - Создавать головы игроков по имени или UUID
  - Работать с `SkullMeta` и т.д.
  - 
---
