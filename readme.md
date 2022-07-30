## 프로듀서 API

### 필수 옵션
- boostarp.servers: 프로듀서가 데이터를 전송할 대상 카프카 클러스터에 속한 브로커 호스트 이름
- key.serializer: 레코드의 메시지 키를 직렬화 하는 클래스 지정
- value.serializer: 레코드의 메시지 값을 직렬화 하는 클래스 지정

### 선택 옵션
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

## 컨슈머 API

### 필수 옵션
- bootstrap.servers: 프로듀서가 데이터를 전송할 대상 카프카 클러스터에 속한 브로커 호스트 이름
- key.deserializer: 레코드의 메시지 키를 역직렬화 하는 클래스 지정
- value.deserializer: 레코드의 메시지 값을 역직렬화 하는 클래스 지정

### 선택 옵션
- group.id : 컨슈머의 그룹 아이디를 지정. subscribe()메소드로 토픽을 구독하여 사용할 경우 필수
- auto.offset.rest: 컨슈머 그룹이 특정 파티션을 읽을 때 저장된 컨슈머 오프셋이 없는 경우 어느 오프셋부터 읽읅지 선택하는 옵션 (latest, earliest, none)
- enable.auto.commit: 자동 커밋 유무. 기본값 true
- auto.commit.interval.ms: 자동 커밋 간격 설정   기본값 5000(5초)
- max.poll.records: poll() 메서드를 통해 반환되는 레코드의 개수를 지정 기본값 500
- session.time.out.ms: 컨슈머가 브로커와 연결이 끊기는 최대 시간. 기본값 10000(10초)
- hearbeat.interval.ms: 하트비트를 전송하는 시간 간격 기본값 3000(3초)
- max.poll.interval.ms: poll() 메서드를 호출하는 간격의 최대 시간 기본값 3000000(5분)
- isolation.level: 트랜잭션 프로듀서가 레코드를 트랜잭션 단위로 보낼 경우 사용


## 어드민 API
카프카 클라이언트의 내부 옵션을 설정하거나 조회하기 위한 API

- describeCluster() 브로커의 정보 조회
- listTopics() 토픽 리스트 조회
- listConsumerGroups() 컨슈머 그룹 조회
- createTopics() 신규 토픽 생성
- createPartitions() 파티션 개수 변경
- createAcls() 접근 제어 규칙 생성
