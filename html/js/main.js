// Generated by CoffeeScript 1.6.1
var arm, arm_down, arm_left, arm_player_down, arm_player_left, arm_player_right, arm_player_up, arm_right, arm_up, check_for_valid_number, comparePositions, getPositions, move_randomly, number, overlaps, random_move_amount, random_speed;

arm = null;

number = null;

$(function() {
  arm = $('#arm');
  number = $('.1');
  return $(document).on('keydown', function(e) {
    e.preventDefault();
    console.log(e.keyCode);
    switch (e.keyCode) {
      case 37:
        console.log('left');
        return arm_player_left(25);
      case 38:
        console.log('up');
        return arm_player_up(25);
      case 39:
        console.log('right');
        return arm_player_right(25);
      case 40:
        console.log('down');
        return arm_player_down(25);
      case 32:
        return check_for_valid_number();
    }
  });
});

move_randomly = function() {
  var direction;
  direction = Math.floor(Math.random() * 4);
  switch (direction) {
    case 1:
      return arm_left(random_move_amount(), random_speed());
    case 2:
      return arm_up(random_move_amount(), random_speed());
    case 3:
      return arm_down(random_move_amount(), random_speed());
    case 0:
      return arm_right(random_move_amount(), random_speed());
  }
};

check_for_valid_number = function() {
  return console.log(overlaps(arm, number));
};

random_move_amount = function() {
  return 100 + Math.random() * 50;
};

random_speed = function() {
  return Math.random() * 200;
};

arm_player_left = function(amount) {
  return arm.css("left", "-=" + amount);
};

arm_player_right = function(amount) {
  return arm.css("left", "+=" + amount);
};

arm_player_up = function(amount) {
  return arm.css("top", "-=" + amount);
};

arm_player_down = function(amount) {
  return arm.css("top", "+=" + amount);
};

arm_left = function(amount, speed) {
  return arm.animate({
    left: "-=" + amount,
    easing: 'linear',
    duration: speed
  });
};

arm_right = function(amount, speed) {
  return arm.animate({
    left: "+=" + amount,
    easing: 'linear',
    duration: speed
  });
};

updatePlayerScore = function(playerScore){
	$("#playerScore").text('score'+ playerScore);
}

postPlayerScore = function(score){
$.ajax({
  url: '/PostHighScore.action?userName='+"lucas"+'&score='+score,
  type: "POST"
});
}
arm_up = function(amount, speed) {
  return arm.animate({
    top: "-=" + amount,
    easing: 'linear',
    duration: speed
  });
};

arm_down = function(amount, speed) {
  return arm.animate({
    top: "+=" + amount,
    easing: 'linear',
    duration: speed
  });
};

overlaps = function(a, b) {
  var pos1, pos2;
  pos1 = getPositions(a);
  pos1[1][1] = 50;
  pos2 = getPositions(b);
  console.log(pos1, pos2);
  return comparePositions(pos1[0], pos2[0]) && comparePositions(pos1[1], pos2[1]);
};

getPositions = function(elem) {
  var height, pos, width;
  pos = $(elem).position();
  width = $(elem).width();
  height = $(elem).height();
  return [[pos.left, pos.left + width], [pos.top, pos.top + height]];
};

comparePositions = function(p1, p2) {
  var r1, r2;
  r1 = p1[0] < p2[0] ? p1 : p2;
  r2 = p1[0] < p2[0] ? p2 : p1;
  return r1[1] > r2[0] || r1[0] === r2[0];
};
