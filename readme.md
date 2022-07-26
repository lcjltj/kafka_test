## 프로듀서 API

###필수 옵션
- boostarp.servers: 프로듀서가 데이터를 전송할 대상 카프카 클러스에 속한 브로커 호스트 이름
- key.serializer: 레코드의 메시지 키를 직렬화 하는 클래스 지정
- value.serializer: 레코드의 메시지 값을 직렬화 하는 클래스 지정

###선택 옵션
- acks: 프로듀서가 전송한 데이터가 정상적으로 저장 되어있는지 전송 여부 확인 옵션 
        default(1): 리더 파티션에 데이터가 저장됬을 시 성공
        0: 프로듀서가 전송한 즉시 데이터 저장 여부와 상관없이 성공
       -1: 리더 파티션과 팔로워 파티션에 데이터가 저장되면 성공
  
- buffer.memory: 브로커로 전송할 데이터를 배치로 모으기 위한 설정 default 32MB
- retries: 프로듀서가 브로커로 부터 에러를 받고 난뒤 재전송을 시도하는 횟수
- batch.size: 배치로 전송할 레코드 최대 용량
- linger.ms: 배치를 전송하기 전까지 기다리는 최소 시간
- partitioner.class: 레코드를 파티션에 전송할떄 적용하는 파티셔너 클래스 지정
- enable.idempotence: 멱등성 프로듀서로 동작할지 여부 default: false
- transactional.id: 레코드를 전송할 떄 레코드를 트랜잭션 단위로 묶을지 여부를 설정 default: null

##컨슈머 API
