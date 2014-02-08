$ ->
    body = $ 'body'
    $(document).on 'keyup', (e)->
        switch e.keyCode
            when 37
                console.log 'left'
                arm_left()
            when 38
                console.log 'up'
                arm_up()
            when 39
                console.log 'right'
                arm_right()
            when 40
                console.log 'down'
                arm_down()


random_move_amount = ->
    100 + Math.random() * 50

random_speed = ->
    Math.random() * 200

arm_left = ->
    arm = $ '#arm'
    arm.animate 
        left: "-=" + random_move_amount()
        easing: 'linear'
        duration: random_speed()

arm_right = ->
    arm = $ '#arm'
    arm.animate 
        left: "+=" + random_move_amount()
        easing: 'linear'
        duration: random_speed()

arm_up = ->
    arm = $ '#arm'
    arm.animate 
        top: "-=" + random_move_amount()
        easing: 'linear'
        duration: random_speed()

arm_down = ->
    arm = $ '#arm'
    arm.animate 
        top: "+=" + random_move_amount()
        easing: 'linear'
        duration: random_speed()