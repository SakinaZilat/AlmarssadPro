//angular.module('myApp', ['ngAnimate', 'ngSanitize', 'ui.bootstrap']);
angular.module('myApp').controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
    var self = this;
     self.player={id:null,firstName:'',lastName:'',position:'',birthPlace:'',birthCountry:'',nationality:'',nowClub:'',clubCountry:'',age:'',birthDate:'',registredDate:'',approved:''};
    self.players=[];
    
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
    self.approve=approve;

    fetchAllUsers();

    function fetchAllUsers(){
        UserService.fetchAllUsers()
            .then(
            function(d) {
                self.players = d;
            	console.log(d);
            },
            function(errResponse){
                console.error('Error while fetching players');
            }
        );
    }

    function createUser(user){
        UserService.createUser(user)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while creating player');
            }
        );
    }

    function updateUser(user, id){
        UserService.updateUser(user, id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while updating User');
            }
        );
    }

    function deleteUser(id){
        UserService.deleteUser(id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while deleting User');
            }
        );
    }
    

    
    function approveUser(user, id){
        UserService.approveUser(user, id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while updating User');
            }
        );
    }

    function submit() {
        if(self.player.id===null){
            console.log('Saving New player', self.player);
            createUser(self.player);
        }else{
            updateUser(self.player, self.player.id);
            console.log('User updated with id ', self.player.id);
        }
        reset();
    }

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.players.length; i++){
            if(self.players[i].id === id) {
                self.player = angular.copy(self.players[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.player.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteUser(id);
        fetchAllUsers();

    }
    
    function approve(id){
        console.log('approved von Admin', id);
        if(self.player.id === id) {
            reset();
        }
        edit(id);
        self.player.approved=true;
        console.log("approve",self.player);
        approveUser(self.player,id);
        reset();
    }


    function reset(){
        self.player={id:null,firstName:'',lastName:'',position:'',birthPlace:'',birthCountry:'',nationality:'',nowClub:'',clubCountry:'',age:'',birthDate:'',registredDate:'',approved:''};
        $scope.myForm.$setPristine(); //reset Form
    }

   
}]);
