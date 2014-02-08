arm = null
number = null
$ ->
    
    # window.setInterval ->
    #     move_randomly()
    # , 500

    arm = $ '#arm'
    number = $ '.1'

    $(document).on 'keydown', (e)->
        e.preventDefault()
        console.log e.keyCode
        switch e.keyCode
            when 37
                console.log 'left'
                arm_player_left(25)
            when 38
                console.log 'up'
                arm_player_up(25)
            when 39
                console.log 'right'
                arm_player_right(25)
            when 40
                console.log 'down'
                arm_player_down(25)
            when 32
                check_for_valid_number()


move_randomly = ->
    direction = Math.floor(Math.random() * 4)
    switch direction
        when 1
            arm_left(random_move_amount(), random_speed())
        when 2
            arm_up(random_move_amount(), random_speed())
        when 3
            arm_down(random_move_amount(), random_speed())
        when 0
            arm_right(random_move_amount(), random_speed())

check_for_valid_number = ->
    console.log overlaps(arm, number)

random_move_amount = ->
    100 + Math.random() * 50

random_speed = ->
    Math.random() * 200

arm_player_left = (amount)->
    arm.css "left", "-=" + amount

arm_player_right = (amount)->
    arm.css "left", "+=" + amount

arm_player_up = (amount)->
    arm.css "top", "-=" + amount

arm_player_down = (amount)->
    arm.css "top", "+=" + amount


arm_left = (amount, speed)->
    arm.animate 
        left: "-=" + amount
        easing: 'linear'
        duration: speed

arm_right = (amount, speed)->
    arm.animate 
        left: "+=" + amount
        easing: 'linear'
        duration: speed

arm_up = (amount, speed)->
    arm.animate 
        top: "-=" + amount
        easing: 'linear'
        duration: speed

arm_down = (amount, speed)->
    arm.animate 
        top: "+=" + amount
        easing: 'linear'
        duration: speed

overlaps = ( a, b ) ->
    pos1 = getPositions( a )
    pos1[1][1] = 50
    pos2 = getPositions( b )
    console.log pos1, pos2
    return comparePositions( pos1[0], pos2[0] ) && 
           comparePositions( pos1[1], pos2[1] );

getPositions = ( elem ) ->
    pos = $( elem ).position();
    width = $( elem ).width();
    height = $( elem ).height();
    return [ [ pos.left, pos.left + width ], [ pos.top, pos.top + height ] ];


comparePositions = ( p1, p2 ) ->
    r1 = if p1[0] < p2[0] then p1 else p2
    r2 = if p1[0] < p2[0] then p2 else p1
    return r1[1] > r2[0] || r1[0] is r2[0];


