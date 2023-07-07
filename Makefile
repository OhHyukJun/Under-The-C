NAME = UnderTheC

all : $(NAME)

$(NAME) :
	docker compose up -d

clean :
	docker compose down --remove-orphans --rmi all --volumes
	cd backend-spring && ./gradlew clean

fclean : clean
	docker network prune --force
	docker volume prune --force
	docker system prune --all --force --volumes
	rm -rf db-mariadb/data

re : fclean all
