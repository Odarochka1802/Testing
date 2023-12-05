class UserRepository:
    def __init__(self):
        self.data = []

    def add_user(self, user):
        self.data.append(user)

    def find_by_name(self, username):
        for user in self.data:
            if user.name == username:
                return True
        return False
