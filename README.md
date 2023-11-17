# bitcamp-practice

## 2023.11.17

### Maven 등의 빌드 도구의 역할
- 빌드에 사용할 정보
- 빌드 순서
- 빌드할 때 사용할 도구


빌드 자동화 용이 node.js의 package


## 2023.11.15

### 몰랐던 git 명령어
Merge (병합): 새로운 병합 커밋이 생성되며, 변경 사항을 통합합니다.

git pull origin main --no-rebase

git pull origin main --rebase=false

git restore --staged 파일명

Rebase (리베이스): 변경 사항을 다른 브랜치 위로 옮겨 합칩니다. 히스토리가 더 선형적으로 유지되어 깔끔한 히스토리를 유지할 수 있습니다.



git pull origin main --rebase=true
선택한 방법으로 변경 사항을 가져오고 나면, 다시 git push를 실행하여 원격 저장소에 변경 사항을 푸시할 수 있습니다.
