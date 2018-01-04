//angular.module('myApp', ['ngAnimate', 'ngSanitize', 'ui.bootstrap']);
angular.module('myApp').controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
    var self = this;
    self.player={id:null,firstName:'',lastName:'',position:'',birthPlace:'',nationality:'',nowClub:'',age:'',birthDate:'',registredDate:'',approved:''};
    self.players=[];
    
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    

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


    function reset(){
        self.player={id:null,firstName:'',lastName:'',position:'',birthPlace:'',nationality:'',nowClub:'',age:'',birthDate:'',registredDate:'',approved:''};
        $scope.myForm.$setPristine(); //reset Form
    }

    //////datesControllers//////////
	
//    self.today = function() {
//        self.dt = new Date();
//      };
//      self.today();
//
//      self.clear = function() {
//        self.dt = null;
//      };
//
//      self.inlineOptions = {
//        customClass: getDayClass,
//        minDate: new Date(),
//        showWeeks: true
//      };
//
//      self.dateOptions = {
//        dateDisabled: disabled,
//        formatYear: 'yy',
//        maxDate: new Date(2020, 5, 22),
//        minDate: new Date(),
//        startingDay: 1
//      };
//
//      // Disable weekend selection
//      function disabled(data) {
//        var date = data.date,
//          mode = data.mode;
//        return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
//      }
//
//      self.toggleMin = function() {
//        self.inlineOptions.minDate = self.inlineOptions.minDate ? null : new Date();
//        self.dateOptions.minDate = self.inlineOptions.minDate;
//      };
//
//      self.toggleMin();
//
//      self.open1 = function() {
//        self.popup1.opened = true;
//      };
//
//      self.open2 = function() {
//        self.popup2.opened = true;
//      };
//
//      self.setDate = function(year, month, day) {
//        self.dt = new Date(year, month, day);
//      };
//
//      self.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
//      self.format = self.formats[0];
//      self.altInputFormats = ['M!/d!/yyyy'];
//
//      self.popup1 = {
//        opened: false
//      };
//
//      self.popup2 = {
//        opened: false
//      };
//
//      var tomorrow = new Date();
//      tomorrow.setDate(tomorrow.getDate() + 1);
//      var afterTomorrow = new Date();
//      afterTomorrow.setDate(tomorrow.getDate() + 1);
//      self.events = [
//        {
//          date: tomorrow,
//          status: 'full'
//        },
//        {
//          date: afterTomorrow,
//          status: 'partially'
//        }
//      ];
//
//      function getDayClass(data) {
//        var date = data.date,
//          mode = data.mode;
//        if (mode === 'day') {
//          var dayToCheck = new Date(date).setHours(0,0,0,0);
//
//          for (var i = 0; i < self.events.length; i++) {
//            var currentDay = new Date(self.events[i].date).setHours(0,0,0,0);
//
//            if (dayToCheck === currentDay) {
//              return self.events[i].status;
//            }
//          }
//        }
//
//        return '';
//      }
	/////////////////////////////
}]);
